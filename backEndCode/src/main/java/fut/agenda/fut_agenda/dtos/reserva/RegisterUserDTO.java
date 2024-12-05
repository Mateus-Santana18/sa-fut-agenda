package fut.agenda.fut_agenda.dtos.reserva;

import fut.agenda.fut_agenda.entities.Role;
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
public class RegisterUserDTO {
  private String email;
  private String senha;
  private String nome;
  private String telefone;
  private Role cargo;
}
