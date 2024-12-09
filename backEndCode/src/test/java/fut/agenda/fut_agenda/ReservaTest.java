package fut.agenda.fut_agenda;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.management.relation.Role;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import fut.agenda.fut_agenda.dtos.reserva.AddUsuarioReservaDTO;
import fut.agenda.fut_agenda.dtos.reserva.SaveReservaDTO;
import fut.agenda.fut_agenda.entities.EstabelecimentoEntity;
import fut.agenda.fut_agenda.entities.Funcao;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.entities.ReservaEntity;
import fut.agenda.fut_agenda.entities.TipoQuadra;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.QuadraRepository;
import fut.agenda.fut_agenda.repositories.ReservaRepository;
import fut.agenda.fut_agenda.repositories.UsuarioRepository;
import fut.agenda.fut_agenda.services.ReservaService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ReservaTest {

  @Mock
  private ReservaRepository reservaRepository;
  @Mock
  private QuadraRepository quadraRepository;
  @Mock
  private UsuarioRepository usuarioRepository;
  @InjectMocks
  private ReservaService reservaService; // Injeta dependências simuladas no serviço

  @Test
  @DisplayName("Aluga jogo com sucesso")
  public void aluga() {
    EstabelecimentoEntity estabelecimentoEntity = EstabelecimentoEntity
        .builder()
        .id(1L)
        .cnpj("41947059000179")
        .endereco("Test")
        .build();

    QuadraEntity quadraEntity = QuadraEntity
        .builder()
        .id(1L)
        .nome("Quadra 1")
        .estabelecimentoEntity(estabelecimentoEntity)
        .tipo(TipoQuadra.GRAMA)
        .build();

    SaveReservaDTO input = SaveReservaDTO
        .builder()
        .quadraId(1L)
        .horario("2024-12-27:9")
        .funcao(Funcao.LINHA)
        .build();

    when(quadraRepository.findById(ArgumentMatchers.any()))
        .thenReturn(Optional.ofNullable(quadraEntity));

    when(reservaRepository.findByQuadraAndHorario(ArgumentMatchers.any(), ArgumentMatchers.any()))
        .thenReturn(Optional.empty());

    ReservaEntity reservaEntity = ReservaEntity
        .builder()
        .quadraEntity(quadraEntity)
        .organizadorEntity(null)
        .reservaUsuarioEntitySet(Set.of())
        .horario("2024-12-27:9")
        .build();

    when(reservaRepository.save(ArgumentMatchers.any()))
        .thenReturn(reservaEntity);

    UsuarioEntity usuarioEntity = UsuarioEntity
        .builder()
        .id(1)
        .email("test@gmail.com")
        .nome("usuario")
        .senha(new BCryptPasswordEncoder().encode("123"))
        .telefone("48991406974")
        .cargo(fut.agenda.fut_agenda.entities.Role.USER)
        .build();

    ReflectionTestUtils.setField(reservaService, "reservaRepository", reservaRepository);
    ReflectionTestUtils.setField(reservaService, "quadraRepository", quadraRepository);
    ReflectionTestUtils.setField(reservaService, "usuarioRepository", usuarioRepository);

    Assertions.assertDoesNotThrow(() -> reservaService.saveReserva(input, usuarioEntity));
  }

  @Test
  @DisplayName("Adiciona participante com sucesso")
  public void addParticipant() {
    EstabelecimentoEntity estabelecimentoEntity = EstabelecimentoEntity
        .builder()
        .id(1L)
        .cnpj("41947059000179")
        .endereco("Test")
        .build();

    QuadraEntity quadraEntity = QuadraEntity
        .builder()
        .id(1L)
        .nome("Quadra 1")
        .estabelecimentoEntity(estabelecimentoEntity)
        .tipo(TipoQuadra.GRAMA)
        .build();

    Mockito.lenient().when(quadraRepository.findById(ArgumentMatchers.any()))
        .thenReturn(Optional.ofNullable(quadraEntity));

    ReservaEntity reservaEntity = ReservaEntity
        .builder()
        .id(1L)
        .quadraEntity(quadraEntity)
        .organizadorEntity(null)
        .reservaUsuarioEntitySet(new HashSet<>())
        .horario("2024-12-27:9")
        .build();

    Mockito.lenient().when(reservaRepository.findById(ArgumentMatchers.any()))
        .thenReturn(Optional.of(reservaEntity));

    UsuarioEntity usuarioEntity = UsuarioEntity
        .builder()
        .id(1)
        .email("test@gmail.com")
        .nome("usuario")
        .senha(new BCryptPasswordEncoder().encode("123"))
        .telefone("48991406974")
        .cargo(fut.agenda.fut_agenda.entities.Role.USER)
        .build();

    Mockito.lenient().when(usuarioRepository.findByEmail(ArgumentMatchers.any()))
        .thenReturn(Optional.of(usuarioEntity));

    AddUsuarioReservaDTO input = AddUsuarioReservaDTO
        .builder()
        .email("test@gmail.com")
        .funcao(Funcao.LINHA)
        .build();

    Mockito.lenient().when(reservaRepository.save(ArgumentMatchers.any()))
        .thenReturn(reservaEntity);

    ReflectionTestUtils.setField(reservaService, "reservaRepository", reservaRepository);
    ReflectionTestUtils.setField(reservaService, "quadraRepository", quadraRepository);
    ReflectionTestUtils.setField(reservaService, "usuarioRepository", usuarioRepository);

    Assertions.assertDoesNotThrow(() -> reservaService.addToReserva(1L, input));
  }
}
