package fut.agenda.fut_agenda.dtos.usuario;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private long expiresIn;
    private Long userId;
    private String nome;
    private String telefone;
    private String email;
}
 
    

