package fut.agenda.fut_agenda.dtos.reserva;

import fut.agenda.fut_agenda.entities.Funcao;
import lombok.Data;

@Data
public class SaveReservaDTO {
  private Long quadraId;
  private String horario;
  private Funcao funcao;
}
