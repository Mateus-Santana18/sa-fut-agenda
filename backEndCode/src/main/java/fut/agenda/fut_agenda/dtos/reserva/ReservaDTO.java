package fut.agenda.fut_agenda.dtos.reserva;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDTO {
  private Long id;
  private String name;
  private String horario;
}
