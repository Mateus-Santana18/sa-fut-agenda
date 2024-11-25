package fut.agenda.fut_agenda.dtos.res;

import java.time.LocalDateTime;
import java.util.List;

import fut.agenda.fut_agenda.entities.UsuarioEntity;



public class ShowEstabelecimentoDTO {
    private long id;
    private String endereco;
    private String cnpj;
    private LocalDateTime horarioAbertura;
    private LocalDateTime horarioFechamento;

    private ShowUsuarioDTO showUsuarioDTO;
    private List<ShowQuadraDTO> quadraList;

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

    public ShowUsuarioDTO getShowUsuarioDTO() {
        return showUsuarioDTO;
    }

    public void setShowUsuarioDTO(ShowUsuarioDTO showUsuarioDTO) {
        this.showUsuarioDTO = showUsuarioDTO;
    }

    public List<ShowQuadraDTO> getQuadraList() {
        return quadraList;
    }

    public void setQuadraList(List<ShowQuadraDTO> quadraList) {
        this.quadraList = quadraList;
    }

    public void setShowUsuarioDTO(UsuarioEntity usuarioEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setShowUsuarioDTO'");
    }



}
