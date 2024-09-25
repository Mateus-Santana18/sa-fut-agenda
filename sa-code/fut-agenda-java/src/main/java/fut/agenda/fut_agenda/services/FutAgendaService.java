package fut.agenda.fut_agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.request.CreateUserDto;
import fut.agenda.fut_agenda.entities.UsuarioFutAgendaEntity;
import fut.agenda.fut_agenda.repositories.FutAgendaRepository;

@Service
public class FutAgendaService {
    
    @Autowired
    FutAgendaRepository futAgendaRepository;

    public List<UsuarioFutAgendaEntity> getAllUsuarios(){
        return futAgendaRepository.findAll();
    }

    public void createUser(CreateUserDto dto) {
        UsuarioFutAgendaEntity entity = new UsuarioFutAgendaEntity();
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setTelefone(dto.getTelefone());
        entity.setSenha(dto.getSenha());
        futAgendaRepository.save(entity);
    }
}
