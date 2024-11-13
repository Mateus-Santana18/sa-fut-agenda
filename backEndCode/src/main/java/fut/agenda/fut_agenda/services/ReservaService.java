package fut.agenda.fut_agenda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.req.ReservaDTO;
import fut.agenda.fut_agenda.entities.OrganizadorEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.entities.ReservaEntity;
import fut.agenda.fut_agenda.repositories.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    public void criarReserva(ReservaDTO dto) {
        ReservaEntity reservaEntity = new ReservaEntity();

        reservaEntity.setId(dto.getId());
        reservaEntity.setHorarioInicioReserva(dto.getHorarioInicioReserva());
        reservaEntity.setHorarioFimReserva(dto.getHorarioFimReserva());
        
        final ReservaEntity reservaEntityPersistance = reservaRepository.save(reservaEntity);

        QuadraEntity quadraEntity = new QuadraEntity();
        quadraEntity.setId(dto.getQuadraDTO().getId());
        quadraEntity.setTipo(dto.getQuadraDTO().getTipo());

        OrganizadorEntity organizadorEntity = new OrganizadorEntity();
        organizadorEntity.setId(dto.getOrganizadorDTO().getId());


        reservaEntityPersistance.setQuadraEntity(quadraEntity);
        reservaEntityPersistance.setOrganizadorEntity(organizadorEntity);
    }
}
