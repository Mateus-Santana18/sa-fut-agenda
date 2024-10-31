package fut.agenda.fut_agenda.dtos.req;

import java.time.LocalDateTime;

public class ReservaDTO {
    
    private long id;
    private LocalDateTime horarioInicioReserva;
    private LocalDateTime horarioFimReserva;

    private QuadraDTO quadraDTO;
    private OrganizadorDTO organizadorDTO;
    private long id_organizador;
    
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
    public QuadraDTO getQuadraDTO() {
        return quadraDTO;
    }
    public void setQuadraDTO(QuadraDTO quadraDTO) {
        this.quadraDTO = quadraDTO;
    }
    public OrganizadorDTO getOrganizadorDTO() {
        return organizadorDTO;
    }
    public void setOrganizadorDTO(OrganizadorDTO organizadorDTO) {
        this.organizadorDTO = organizadorDTO;
    }

    
}
