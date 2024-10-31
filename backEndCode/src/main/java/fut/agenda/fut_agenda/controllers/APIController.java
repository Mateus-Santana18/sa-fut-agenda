package fut.agenda.fut_agenda.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fut.agenda.fut_agenda.dtos.req.UsuarioDTO;

@RestController
@RequestMapping("/usuario")
public class APIController {

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDTO dto ) {

        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {

        return ResponseEntity.status(200).build();
    }
}
