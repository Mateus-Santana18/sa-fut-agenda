package fut.agenda.fut_agenda.dtos;

import fut.agenda.fut_agenda.dtos.quadra.QuadraDTO;
import java.time.LocalDateTime;
import java.util.List;

public class EstabelecimentoDTO {
    
    private long id;
    private String endereco;
    private String cnpj;
    private LocalDateTime horarioAbertura;
    private LocalDateTime horarioFechamento;

    private long id_usuario;
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

    public List<QuadraDTO> getQuadraList() {
        return quadraList;
    }

    public void setQuadraList(List<QuadraDTO> quadraList) {
        this.quadraList = quadraList;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

}
