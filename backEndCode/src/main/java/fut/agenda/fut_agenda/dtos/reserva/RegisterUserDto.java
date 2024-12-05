package fut.agenda.fut_agenda.dtos.reserva;

import fut.agenda.fut_agenda.entities.Role;
import lombok.Data;

@Data
public class RegisterUserDto {
  private String email;
  private String senha;
  private String nome;
  private String telefone;
  private Role cargo;
}
