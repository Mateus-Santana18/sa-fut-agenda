package fut.agenda.fut_agenda.services;

import fut.agenda.fut_agenda.entities.OrganizadorEntity;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizadorService {
    
    @Autowired
    OrganizadorRepository organizadorRepository;
}
