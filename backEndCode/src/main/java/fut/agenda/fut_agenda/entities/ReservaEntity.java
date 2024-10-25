package fut.agenda.fut_agenda.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "reserva")
public class ReservaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "horario_inicio_reserva")
    private LocalDateTime horarioInicioReserva;

    @Column(name = "horario_fim_reserva")
    private LocalDateTime horarioFimReserva;
    
}
