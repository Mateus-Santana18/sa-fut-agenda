package fut.agenda.fut_agenda.dtos.req;

public class QuadraDTO {
    
    private long id;
    private String tipo;
    private long idEstabelecimento;
    
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
    public long getIdEstabelecimento() {
        return idEstabelecimento;
    }
    public void setIdEstabelecimento(long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    
}
