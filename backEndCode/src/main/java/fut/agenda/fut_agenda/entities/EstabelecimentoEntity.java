package fut.agenda.fut_agenda.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "estabelecimento")
public class EstabelecimentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "horario_abertura")
    private LocalDateTime horarioAbertura;

    @Column(name = "horario_encerramento")
    private LocalDateTime horarioEncerramento;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;

    @OneToMany
    @JoinColumn(name = "id_quadra")
    private List<QuadraEntity> quadraList; 

}
