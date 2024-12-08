package fut.agenda.fut_agenda.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fut.agenda.fut_agenda.dtos.usuario.LoginResponse;
import fut.agenda.fut_agenda.dtos.usuario.LoginUsuarioDTO;
import fut.agenda.fut_agenda.dtos.reserva.RegisterUserDTO;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.services.AuthenticationService;
import fut.agenda.fut_agenda.services.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterUserDTO registerUserDto) {
        UsuarioEntity registeredUser = authenticationService.signup(registerUserDto);

        LoginResponse response = new LoginResponse();
        response.setUserId(registeredUser.getId());
        response.setNome(registeredUser.getNome());
        response.setTelefone(registeredUser.getTelefone());
        response.setEmail(registeredUser.getEmail());
        response.setCargo(registeredUser.getCargo());

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<LoginResponse> update(@RequestBody RegisterUserDTO registerUserDto) {
        UsuarioEntity registeredUser = authenticationService.update(registerUserDto);

        String jwtToken = jwtService.generateToken(registeredUser);

        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.getExpirationTime());
        response.setUserId(registeredUser.getId());
        response.setNome(registeredUser.getNome());
        response.setTelefone(registeredUser.getTelefone());
        response.setEmail(registeredUser.getEmail());
        response.setCargo(registeredUser.getCargo());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public void autoDelete() {
        authenticationService.autoDelete();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUsuarioDTO loginUserDto) {
        UsuarioEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.getExpirationTime());
        response.setUserId(authenticatedUser.getId());
        response.setNome(authenticatedUser.getNome());
        response.setTelefone(authenticatedUser.getTelefone());
        response.setEmail(authenticatedUser.getEmail());
        response.setCargo(authenticatedUser.getCargo());

        return ResponseEntity.ok(response);
    }
}


