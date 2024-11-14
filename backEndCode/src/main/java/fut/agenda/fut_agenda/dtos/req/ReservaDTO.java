package fut.agenda.fut_agenda.dtos.req;

import java.time.LocalDateTime;

public class ReservaDTO {

    private LocalDateTime horarioInicioReserva;
    private LocalDateTime horarioFimReserva;

    private long idQuadra;
    private long idOrganizador;

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

    public long getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(long idQuadra) {
        this.idQuadra = idQuadra;
    }

    public long getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(long idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

}
