package fut.agenda.fut_agenda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.req.OrganizadorDTO;
import fut.agenda.fut_agenda.entities.OrganizadorEntity;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.OrganizadorRepository;

@Service
public class OrganizadorService {
    
    @Autowired
    OrganizadorRepository organizadorRepository;

    public void criarOrganizador ( OrganizadorDTO dto) {

        OrganizadorEntity organizadorEntity = new OrganizadorEntity();

        organizadorEntity.setId(dto.getId());

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(dto.getId());

        organizadorEntity.setUsuarioEntity(usuarioEntity);
        organizadorRepository.save(organizadorEntity);
    }


}