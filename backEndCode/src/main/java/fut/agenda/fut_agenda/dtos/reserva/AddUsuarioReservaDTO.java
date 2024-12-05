package fut.agenda.fut_agenda.dtos.reserva;

import fut.agenda.fut_agenda.entities.Funcao;
import lombok.Data;

@Data
public class AddUsuarioReservaDTO {
  private String email;
  private Funcao funcao;
}
