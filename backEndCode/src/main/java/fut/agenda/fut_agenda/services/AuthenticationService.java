package fut.agenda.fut_agenda.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.usuario.LoginUsuarioDTO;
import fut.agenda.fut_agenda.dtos.reserva.RegisterUserDTO;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.UsuarioRepository;

@Service
public class AuthenticationService {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UsuarioRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity signup(RegisterUserDTO input) {
        if (userRepository.findByEmail(input.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        UsuarioEntity user = new UsuarioEntity();
        user.setNome(input.getNome());
        user.setEmail(input.getEmail());
        user.setTelefone(input.getTelefone());
        user.setSenha(passwordEncoder.encode(input.getSenha()));
        user.setCargo(input.getCargo());

        return userRepository.save(user);
    }

    public UsuarioEntity authenticate(LoginUsuarioDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getSenha()));
        var user = userRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("E-mail não encontrado"));
        if (!passwordEncoder.matches(input.getSenha(), user.getPassword())) {
            throw new RuntimeException("Senha invalida");
        }
        return user;
    }
}
 
    

