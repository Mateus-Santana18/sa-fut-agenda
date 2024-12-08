package fut.agenda.fut_agenda.dtos.quadra;

import fut.agenda.fut_agenda.entities.TipoQuadra;
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
public class QuadraDTO {
    
    private long id;
    private String nome;
    private TipoQuadra tipo;
    private long idEstabelecimento;
}
