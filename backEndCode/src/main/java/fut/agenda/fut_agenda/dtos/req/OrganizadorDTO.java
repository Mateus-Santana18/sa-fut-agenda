package fut.agenda.fut_agenda.dtos.req;

public class OrganizadorDTO {
    private long id;
    private UsuarioDTO usuarioDTO;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }
    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    
}
