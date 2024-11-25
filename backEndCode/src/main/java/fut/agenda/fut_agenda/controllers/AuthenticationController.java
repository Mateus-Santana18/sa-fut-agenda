package fut.agenda.fut_agenda.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fut.agenda.fut_agenda.dtos.res.LoginResponse;
import fut.agenda.fut_agenda.dtos.res.LoginUsuarioDTO;
import fut.agenda.fut_agenda.dtos.res.RegisterUserDto;
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
    public ResponseEntity<UsuarioEntity> register(@RequestBody RegisterUserDto registerUserDto) {
        UsuarioEntity registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUsuarioDTO loginUserDto) {
        UsuarioEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(response);
    }
}


