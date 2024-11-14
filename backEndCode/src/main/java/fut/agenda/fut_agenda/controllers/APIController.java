package fut.agenda.fut_agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fut.agenda.fut_agenda.dtos.req.UsuarioDTO;
import fut.agenda.fut_agenda.dtos.res.ShowUsuarioDTO;
import fut.agenda.fut_agenda.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class APIController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDTO dto ) {

        usuarioService.criarUsuario(dto);

        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<?> listarUsuarios() {

        List<ShowUsuarioDTO> showUsuarioDTOs = usuarioService.listarUsuarios();

        return ResponseEntity.status(200).body(showUsuarioDTOs);
    }
}
