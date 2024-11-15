package fut.agenda.fut_agenda.dtos.res;

public class ShowQuadraDTO {
    private long id;
    private String tipo;
    private ShowEstabelecimentoDTO showEstabelecimentoDTO;
    
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
    public ShowEstabelecimentoDTO getShowEstabelecimentoDTO() {
        return showEstabelecimentoDTO;
    }
    public void setShowEstabelecimentoDTO(ShowEstabelecimentoDTO showEstabelecimentoDTO) {
        this.showEstabelecimentoDTO = showEstabelecimentoDTO;
    }
    
    
}
