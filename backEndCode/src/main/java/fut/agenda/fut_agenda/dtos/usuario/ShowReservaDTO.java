package fut.agenda.fut_agenda.dtos.usuario;

import fut.agenda.fut_agenda.dtos.ShowOrganizadorDTO;
import fut.agenda.fut_agenda.dtos.quadra.ShowQuadraDTO;
import java.time.LocalDateTime;



public class ShowReservaDTO {
     private long id;
    private LocalDateTime horarioInicioReserva;
    private LocalDateTime horarioFimReserva;

    private ShowQuadraDTO showQuadraDTO;
    private ShowOrganizadorDTO showOrganizadorDTO;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LocalDateTime getHorarioInicioReserva() {
        return horarioInicioReserva;
    }
    public void setHorarioInicioReserva(LocalDateTime horarioInicioReserva) {
        this.horarioInicioReserva = horarioInicioReserva;
    }
    public LocalDateTime getHorarioFimReserva() {
        return horarioFimReserva;
    }
    public void setHorarioFimReserva(LocalDateTime horarioFimReserva) {
        this.horarioFimReserva = horarioFimReserva;
    }
    public ShowQuadraDTO getShowQuadraDTO() {
        return showQuadraDTO;
    }
    public void setShowQuadraDTO(ShowQuadraDTO showQuadraDTO) {
        this.showQuadraDTO = showQuadraDTO;
    }
    public ShowOrganizadorDTO getShowOrganizadorDTO() {
        return showOrganizadorDTO;
    }
    public void setShowOrganizadorDTO(ShowOrganizadorDTO showOrganizadorDTO) {
        this.showOrganizadorDTO = showOrganizadorDTO;
    }




}
