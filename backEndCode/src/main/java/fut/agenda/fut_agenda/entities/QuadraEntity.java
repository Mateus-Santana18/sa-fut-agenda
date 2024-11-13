package fut.agenda.fut_agenda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "quadra")
public class QuadraEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_estabelecimento")
    private EstabelecimentoEntity estabelecimentoEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EstabelecimentoEntity getEstabelecimentoEntity() {
        return estabelecimentoEntity;
    }

    public void setEstabelecimentoEntity(EstabelecimentoEntity estabelecimentoEntity) {
        this.estabelecimentoEntity = estabelecimentoEntity;
    }
    

}
