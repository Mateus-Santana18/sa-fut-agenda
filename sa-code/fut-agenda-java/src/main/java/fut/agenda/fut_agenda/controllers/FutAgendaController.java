package fut.agenda.fut_agenda.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fut.agenda.fut_agenda.dtos.request.CreateUserDto;
import fut.agenda.fut_agenda.services.FutAgendaService;

@RestController
@RequestMapping("/fut-agenda")
public class FutAgendaController {
    
    @Autowired
    FutAgendaService futAgendaService;

    @GetMapping("/principal")
    public ResponseEntity<?> findFutAgenda(){
        var usuarios = futAgendaService.getAllUsuarios();

        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/login")
    public ResponseEntity<?> postUserFutAgenda(@RequestBody CreateUserDto dto){
        futAgendaService.createUser(dto);
        
        return ResponseEntity.ok(dto);


    }
}