package fut.agenda.fut_agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.req.ReservaDTO;
import fut.agenda.fut_agenda.dtos.res.ShowOrganizadorDTO;
import fut.agenda.fut_agenda.dtos.res.ShowQuadraDTO;
import fut.agenda.fut_agenda.dtos.res.ShowReservaDTO;
import fut.agenda.fut_agenda.entities.OrganizadorEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.entities.ReservaEntity;
import fut.agenda.fut_agenda.repositories.ReservaRepository;
import jakarta.transaction.Transactional;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    public void criarReserva(ReservaDTO dto) {
        ReservaEntity reservaEntity = new ReservaEntity();

        reservaEntity.setHorarioInicioReserva(dto.getHorarioInicioReserva());
        reservaEntity.setHorarioFimReserva(dto.getHorarioFimReserva());

        QuadraEntity quadraEntity = new QuadraEntity();
        quadraEntity.setId(dto.getIdQuadra());

        reservaEntity.setQuadraEntity(quadraEntity);

        OrganizadorEntity organizadoEntity = new OrganizadorEntity();
        organizadoEntity.setId(dto.getIdOrganizador());

        reservaEntity.setOrganizadorEntity(organizadoEntity);

        reservaRepository.save(reservaEntity);
    }

    public List<ShowReservaDTO> listarReservas() {
        List<ReservaEntity> reservaEntities = reservaRepository.findAll();

        return reservaEntities.stream().map(reserva -> {
            ShowReservaDTO showReservaDTO = new ShowReservaDTO();

            showReservaDTO.setId(reserva.getId());
            showReservaDTO.setHorarioInicioReserva(reserva.getHorarioInicioReserva());
            showReservaDTO.setHorarioFimReserva(reserva.getHorarioFimReserva());

            ShowQuadraDTO showQuadraDTO = new ShowQuadraDTO();
            showQuadraDTO.setId(reserva.getId());
            showQuadraDTO.setTipo(reserva.getTipo());

            ShowOrganizadorDTO showOrganizadorDTO = new ShowOrganizadorDTO();
            showOrganizadorDTO.setId(reserva.getId());

            showReservaDTO.setShowQuadraDTO(showQuadraDTO);
            showReservaDTO.setShowOrganizadorDTO(showOrganizadorDTO);
            // showReservaDTO.setIdQuadra(reserva.getQuadraEntity().getId());
            // showReservaDTO.setIdOrganizador(reserva.getOrganizadorEntity().getId());

            return showReservaDTO;

        }).toList();
    }

    public ShowReservaDTO getReservaById(long id) {
        Optional<ReservaEntity> optionalReservaEntity = reservaRepository.findById(id);

        if (optionalReservaEntity.isEmpty()) {
            // Joga uma excecao
            return new ShowReservaDTO();
        }

        ReservaEntity reservaEntity = optionalReservaEntity.get();

        ShowReservaDTO dto = new ShowReservaDTO();
        dto.setId(reservaEntity.getId());
        dto.setHorarioInicioReserva(reservaEntity.getHorarioInicioReserva());
        dto.setHorarioFimReserva(reservaEntity.getHorarioFimReserva());

        ShowQuadraDTO quadraDTO = new ShowQuadraDTO();
        quadraDTO.setId(reservaEntity.getId());
        quadraDTO.setTipo(reservaEntity.getTipo());

        ShowOrganizadorDTO organizadorDTO = new ShowOrganizadorDTO();
        organizadorDTO.setId(reservaEntity.getId());

        dto.setShowQuadraDTO(quadraDTO);
        dto.setShowOrganizadorDTO(organizadorDTO);
        // dto.setIdOrganizador(reservaEntity.getQuadraEntity().getId());
        // dto.setIdQuadra(reservaEntity.getOrganizadorEntity().getId());

        return dto;
    }

    @Transactional
    public void deleteReservaByid(long id) {
        Optional<ReservaEntity> optionalReservaEntity = reservaRepository.findById(id);

        if (optionalReservaEntity.isPresent()) {
            reservaRepository.deleteById(id);
        } else {
            // throw new deletableException();
        }
    }

    @Transactional
    public void changeReservaById(long id, ReservaDTO dto) {
        Optional<ReservaEntity> optionalReservaEntity = reservaRepository.findById(id);

        if (optionalReservaEntity.isEmpty()) {
            // joga uma excecao
        }

        ReservaEntity reservaEntity = optionalReservaEntity.get();

        reservaEntity.setHorarioInicioReserva(dto.getHorarioInicioReserva());
        reservaEntity.setHorarioFimReserva(dto.getHorarioFimReserva());

        QuadraEntity quadraEntity = new QuadraEntity();
        quadraEntity.setId(dto.getIdQuadra());

        reservaEntity.setQuadraEntity(quadraEntity);

        OrganizadorEntity organizadoEntity = new OrganizadorEntity();
        organizadoEntity.setId(dto.getIdOrganizador());

        reservaEntity.setOrganizadorEntity(organizadoEntity);

        reservaRepository.save(reservaEntity);

    }

}
