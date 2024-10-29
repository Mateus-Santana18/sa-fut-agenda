package fut.agenda.fut_agenda.dtos.req;

import java.time.LocalDateTime;
import java.util.List;

public class EstabelecimentoDTO {
    
    private long id;
    private String endereco;
    private String cnpj;
    private LocalDateTime horarioAbertura;
    private LocalDateTime horarioFechamento;

    private UsuarioDTO usuarioDTO;
    private List<QuadraDTO> quadraList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDateTime getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(LocalDateTime horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public LocalDateTime getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(LocalDateTime horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public List<QuadraDTO> getQuadraList() {
        return quadraList;
    }

    public void setQuadraList(List<QuadraDTO> quadraList) {
        this.quadraList = quadraList;
    }

}
