package fut.agenda.fut_agenda.dtos.reserva;

import fut.agenda.fut_agenda.entities.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUsuarioReservaDTO {
  private String email;
  private Funcao funcao;
}
