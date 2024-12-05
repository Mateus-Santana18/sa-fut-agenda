package fut.agenda.fut_agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.usuario.UsuarioDTO;
import fut.agenda.fut_agenda.dtos.usuario.ShowUsuarioDTO;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public void criarUsuario(UsuarioDTO dto) {

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        
        usuarioEntity.setId(dto.getId());
        usuarioEntity.setNome(dto.getNome());
        usuarioEntity.setEmail(dto.getEmail());
        usuarioEntity.setTelefone(dto.getTelefone());
        usuarioEntity.setSenha(dto.getSenha());

        usuarioRepository.save(usuarioEntity);

    }

    public List<ShowUsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();

        return usuarioEntities.stream().map(usuario -> {
            ShowUsuarioDTO showUsuarioDTO = new ShowUsuarioDTO();

            showUsuarioDTO.setId(usuario.getId());
            showUsuarioDTO.setNome(usuario.getNome());
            showUsuarioDTO.setEmail(usuario.getEmail());
            showUsuarioDTO.setTelefone(usuario.getTelefone());

            return showUsuarioDTO;
        }).toList();
    }

    public ShowUsuarioDTO getUsuarioById(long id) {

        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(id);

        if(optionalUsuarioEntity.isEmpty()){
            // Joga uma excecao
            return new ShowUsuarioDTO();
        }

        UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();

        ShowUsuarioDTO dto = new ShowUsuarioDTO();
        dto.setId(usuarioEntity.getId());
        dto.setNome(usuarioEntity.getNome());
        dto.setEmail(usuarioEntity.getEmail());
        dto.setTelefone(usuarioEntity.getTelefone());

        return dto;
    }

    @Transactional
    public void deleteUsuarioById(long id) {

        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(id);

        if(optionalUsuarioEntity.isPresent()){
            usuarioRepository.deleteById(id);
        }else {
            // throw new deletableException();
        }
    }

    @Transactional
    public void changeUsuarioById(long id, UsuarioDTO dto) {
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(id);

        if (optionalUsuarioEntity.isEmpty()) {
            // jogar uma excecao
        }

        UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();

        usuarioEntity.setNome(dto.getNome());
        usuarioEntity.setTelefone(dto.getTelefone());
        usuarioEntity.setSenha(dto.getSenha());

        usuarioRepository.save(usuarioEntity);
    }
}
