package fut.agenda.fut_agenda.dtos.reserva;

import fut.agenda.fut_agenda.entities.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveReservaDTO {
  private Long quadraId;
  private String horario;
  private Funcao funcao;
}
