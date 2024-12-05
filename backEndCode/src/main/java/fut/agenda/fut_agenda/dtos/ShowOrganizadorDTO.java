package fut.agenda.fut_agenda.dtos;

import fut.agenda.fut_agenda.dtos.usuario.ShowUsuarioDTO;

public class ShowOrganizadorDTO {
    private long id;
    private ShowUsuarioDTO showUsuarioDTO;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public ShowUsuarioDTO getShowUsuarioDTO() {
        return showUsuarioDTO;
    }
    public void setShowUsuarioDTO(ShowUsuarioDTO showUsuarioDTO) {
        this.showUsuarioDTO = showUsuarioDTO;
    }

}
