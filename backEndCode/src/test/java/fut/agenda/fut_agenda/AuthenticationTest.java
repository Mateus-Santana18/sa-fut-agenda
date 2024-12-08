package fut.agenda.fut_agenda;

import static org.mockito.Mockito.when;

import fut.agenda.fut_agenda.dtos.reserva.RegisterUserDTO;
import fut.agenda.fut_agenda.dtos.usuario.LoginUsuarioDTO;
import fut.agenda.fut_agenda.entities.Role;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.UsuarioRepository;
import fut.agenda.fut_agenda.services.AuthenticationService;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AuthenticationTest {

  @Mock
  private UsuarioRepository personRepo; // Simula o repositório de usuários
  @Mock
  private AuthenticationManager authenticationManager; // Simula o gerenciador de autenticação
  @InjectMocks
  private AuthenticationService authenticationService; // Injeta dependências simuladas no serviço

  @Test
  @DisplayName("login com sucesso")
  public void loginUser() {
    // Dados simulados para o teste
    String email = "test@email.com";
    UsuarioEntity usuarioEntity = UsuarioEntity
        .builder()
        .id(1)
        .email(email)
        .nome("usuario")
        .senha(new BCryptPasswordEncoder().encode("123")) // Senha codificada
        .telefone("48991406974")
        .cargo(Role.USER)
        .build();

    // Simula o comportamento do repositório ao buscar um usuário pelo e-mail
    when(personRepo.findByEmail(ArgumentMatchers.any()))
        .thenReturn(Optional.of(usuarioEntity));

    // Cria um objeto de entrada para o login
    LoginUsuarioDTO input = LoginUsuarioDTO
        .builder()
        .email(email)
        .senha("123") // Senha em texto plano
        .build();

    // Simula a autenticação bem-sucedida
    when(authenticationManager.authenticate(ArgumentMatchers.any()))
        .thenReturn(null);

    // Configura campos privados no serviço de autenticação
    ReflectionTestUtils.setField(authenticationService, "userRepository", personRepo);
    ReflectionTestUtils.setField(authenticationService, "authenticationManager", authenticationManager);
    ReflectionTestUtils.setField(authenticationService, "passwordEncoder", new BCryptPasswordEncoder());

    // Verifica se a autenticação não lança nenhuma exceção
    Assertions.assertDoesNotThrow(() -> authenticationService.authenticate(input));
  }

  @Test
  @DisplayName("Registro de usuário sem erro")
  public void signupUser() {
    // Dados simulados para o teste
    String email = "test@email.com";
    UsuarioEntity usuarioEntity = UsuarioEntity
        .builder()
        .id(1)
        .email(email)
        .nome("usuario")
        .senha("123")
        .telefone("48991406974")
        .cargo(Role.USER)
        .build();

    // Simula o comportamento do repositório ao salvar um usuário
    when(personRepo.save(ArgumentMatchers.any()))
        .thenReturn(usuarioEntity);

    // Simula que o e-mail ainda não foi registrado
    when(personRepo.findByEmail(ArgumentMatchers.any()))
        .thenReturn(Optional.empty());

    // Cria um objeto de entrada para o registro
    RegisterUserDTO input = RegisterUserDTO
        .builder()
        .nome("usuario")
        .email(email)
        .senha(new BCryptPasswordEncoder().encode("123")) // Codifica a senha
        .telefone("48991406974")
        .build();

    // Configura campos privados no serviço de autenticação
    ReflectionTestUtils.setField(authenticationService, "userRepository", personRepo);
    ReflectionTestUtils.setField(authenticationService, "passwordEncoder", new BCryptPasswordEncoder());

    // Verifica se o registro não lança nenhuma exceção
    Assertions.assertDoesNotThrow(() -> authenticationService.signup(input));
  }

  @Test
  @DisplayName("Conflito de e-mail no cadastro de usuário")
  public void emailConflict() {
    String email = "test@email.com";

    // Cria uma entidade de usuário já existente
    UsuarioEntity usuarioEntity = UsuarioEntity
        .builder()
        .id(1)
        .email(email)
        .nome("usuario")
        .senha("123")
        .telefone("48991406974")
        .cargo(Role.USER)
        .build();

    // Simula que o e-mail já está registrado
    when(personRepo.findByEmail(ArgumentMatchers.any()))
        .thenReturn(Optional.ofNullable(usuarioEntity));

    // Cria um objeto de entrada para o registro
    RegisterUserDTO input = RegisterUserDTO
        .builder()
        .nome("usuario")
        .email(email)
        .senha(new BCryptPasswordEncoder().encode("123"))
        .telefone("48991406974")
        .build();

    // Configura campos privados no serviço de autenticação
    ReflectionTestUtils.setField(authenticationService, "userRepository", personRepo);
    ReflectionTestUtils.setField(authenticationService, "passwordEncoder", new BCryptPasswordEncoder());

    // Verifica se o registro lança uma exceção devido ao e-mail duplicado
    Assertions.assertThrows(RuntimeException.class, () -> authenticationService.signup(input));
  }

  @Test
  @DisplayName("Senha Incorreta no login")
  public void incorrectPassword() {
    String email = "test@email.com";

    // Cria uma entidade de usuário com senha codificada
    UsuarioEntity usuarioEntity = UsuarioEntity
        .builder()
        .id(1)
        .email(email)
        .nome("usuario")
        .senha(new BCryptPasswordEncoder().encode("123"))
        .telefone("48991406974")
        .cargo(Role.USER)
        .build();

    // Simula o comportamento do repositório ao buscar um usuário
    when(personRepo.findByEmail(ArgumentMatchers.any()))
        .thenReturn(Optional.of(usuarioEntity));

    // Cria um objeto de entrada para o login
    LoginUsuarioDTO input = LoginUsuarioDTO
        .builder()
        .email(email)
        .senha("12") // Senha incorreta
        .build();

    // Simula uma autenticação válida
    when(authenticationManager.authenticate(ArgumentMatchers.any()))
        .thenReturn(new UsernamePasswordAuthenticationToken(usuarioEntity, null, List.of()));

    // Configura campos privados no serviço de autenticação
    ReflectionTestUtils.setField(authenticationService, "userRepository", personRepo);
    ReflectionTestUtils.setField(authenticationService, "authenticationManager", authenticationManager);

    // Verifica se o login lança uma exceção devido à senha incorreta
    Assertions.assertThrows(RuntimeException.class, () -> authenticationService.authenticate(input));
  }

  @Test
  @DisplayName("Email não encontrado no login")
  public void notFoundEmailLogin() {
    String email = "test@email.com";

    // Simula que o e-mail não está registrado no banco
    when(personRepo.findByEmail(ArgumentMatchers.any()))
        .thenReturn(Optional.empty());

    // Cria um objeto de entrada para o login
    LoginUsuarioDTO input = LoginUsuarioDTO
        .builder()
        .email(email)
        .senha("123")
        .build();

    // Simula uma autenticação válida
    when(authenticationManager.authenticate(ArgumentMatchers.any()))
        .thenReturn(new UsernamePasswordAuthenticationToken(null, null, List.of()));

    // Configura campos privados no serviço de autenticação
    ReflectionTestUtils.setField(authenticationService, "userRepository", personRepo);
    ReflectionTestUtils.setField(authenticationService, "authenticationManager", authenticationManager);

    // Verifica se o login lança uma exceção devido ao e-mail não encontrado
    Assertions.assertThrows(RuntimeException.class, () -> authenticationService.authenticate(input));
  }
}
