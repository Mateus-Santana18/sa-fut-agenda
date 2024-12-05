package fut.agenda.fut_agenda.dtos.quadra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuadraHorarioDTO {
  private Long id;
  private String nome;
  private Long reservaId;
  private String endereco;
  private String horario;
}
