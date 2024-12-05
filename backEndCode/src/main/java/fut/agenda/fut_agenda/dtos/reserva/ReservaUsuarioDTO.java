package fut.agenda.fut_agenda.dtos.reserva;

import fut.agenda.fut_agenda.dtos.usuario.UsuarioDTO;
import fut.agenda.fut_agenda.entities.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaUsuarioDTO {
  private ReservaDTO reserva;
  private UsuarioDTO usuario;
  private Long adminId;
  private Funcao funcao;
}
