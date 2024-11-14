package fut.agenda.fut_agenda.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "horario_inicio_reserva")
    private LocalDateTime horarioInicioReserva;

    @Column(name = "horario_fim_reserva")
    private LocalDateTime horarioFimReserva;

    @OneToOne
    @JoinColumn(name = "id_quadra")
    private QuadraEntity quadraEntity;

    @OneToOne
    @JoinColumn(name = "id_organizador")
    private OrganizadorEntity organizadorEntity;

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

    public QuadraEntity getQuadraEntity() {
        return quadraEntity;
    }

    public void setQuadraEntity(QuadraEntity quadraEntity) {
        this.quadraEntity = quadraEntity;
    }

    public OrganizadorEntity getOrganizadorEntity() {
        return organizadorEntity;
    }

    public void setOrganizadorEntity(OrganizadorEntity organizadorEntity) {
        this.organizadorEntity = organizadorEntity;
    }

    public String getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    }

}
