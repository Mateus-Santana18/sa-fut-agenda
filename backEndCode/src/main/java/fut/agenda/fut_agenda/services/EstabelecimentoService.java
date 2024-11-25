package fut.agenda.fut_agenda.services;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.req.EstabelecimentoDTO;
import fut.agenda.fut_agenda.dtos.res.ShowEstabelecimentoDTO;
import fut.agenda.fut_agenda.dtos.res.ShowQuadraDTO;
import fut.agenda.fut_agenda.entities.EstabelecimentoEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.EstabelecimentoRepository;
import jakarta.transaction.Transactional;

@Service
public class EstabelecimentoService {

    @Autowired
    EstabelecimentoRepository estabelecimentoRepository;

    public void createEstabelecimento(EstabelecimentoDTO dto) {
        EstabelecimentoEntity estabelecimentoEntity = new EstabelecimentoEntity();

        estabelecimentoEntity.setId(dto.getId());
        estabelecimentoEntity.setCnpj(dto.getCnpj());
        estabelecimentoEntity.setEndereco(dto.getEndereco());
        estabelecimentoEntity.setHorarioAbertura(dto.getHorarioAbertura());
        estabelecimentoEntity.setHorarioEncerramento(dto.getHorarioFechamento());

        final EstabelecimentoEntity estabelecimentoEntityPersistance = estabelecimentoRepository.save(estabelecimentoEntity); 

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(dto.getId());

        List<QuadraEntity> quadraEntityList = dto.getQuadraList().stream().map(quadra -> {
            QuadraEntity quadraEntity = new QuadraEntity();
            quadraEntity.setId(quadra.getId());
            quadraEntity.setTipo(quadra.getTipo());
            quadraEntity.setEstabelecimentoEntity(estabelecimentoEntityPersistance);

            return quadraEntity;
        }).toList();

        estabelecimentoEntity.setQuadraList(quadraEntityList);
        estabelecimentoEntity.setUsuarioEntity(usuarioEntity);
        estabelecimentoRepository.save(estabelecimentoEntity);

    }

    public List<ShowEstabelecimentoDTO> listarEstabelecimentos () {
        List<EstabelecimentoEntity> estabelecimentoEntityList = estabelecimentoRepository.findAll();

        return estabelecimentoEntityList.stream().map(estabelecimento -> {
            ShowEstabelecimentoDTO showEstabelecimentoDTO = new ShowEstabelecimentoDTO();
            List<ShowQuadraDTO> quadraList = new ArrayList<>();

            for (QuadraEntity quadra : estabelecimento.getQuadraList()) {
                ShowQuadraDTO showQuadraDTO = new ShowQuadraDTO();
                showQuadraDTO.setTipo(quadra.getTipo());
                quadraList.add(showQuadraDTO);
            }

            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setId(estabelecimento.getUsuarioEntity().getId());

            showEstabelecimentoDTO.setCnpj(estabelecimento.getCnpj());
            showEstabelecimentoDTO.setEndereco(estabelecimento.getEndereco());
            showEstabelecimentoDTO.setHorarioAbertura(estabelecimento.getHorarioAbertura());
            showEstabelecimentoDTO.setHorarioFechamento(estabelecimento.getHorarioEncerramento());
            showEstabelecimentoDTO.setQuadraList(quadraList);
            return showEstabelecimentoDTO;
        }).toList();
    }

    public ShowEstabelecimentoDTO getEstabelecimentoById(long id) {
        Optional<EstabelecimentoEntity> optionalEstabelecimentoEntity = estabelecimentoRepository.findById(id);

        if(optionalEstabelecimentoEntity.isEmpty()) {
            // Joga uma ex
            return new ShowEstabelecimentoDTO();
        }

        EstabelecimentoEntity estabelecimentoEntity = optionalEstabelecimentoEntity.get();
        ShowEstabelecimentoDTO showEstabelecimentoDTO = new ShowEstabelecimentoDTO();
        List<ShowQuadraDTO> quadraList = new ArrayList<>();

        for (QuadraEntity quadra : estabelecimentoEntity.getQuadraList()) {
            ShowQuadraDTO showQuadraDTO = new ShowQuadraDTO();
            showQuadraDTO.setTipo(quadra.getTipo());
            quadraList.add(showQuadraDTO);
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(estabelecimentoEntity.getUsuarioEntity().getId());

        showEstabelecimentoDTO.setCnpj(estabelecimentoEntity.getCnpj());
        showEstabelecimentoDTO.setEndereco(estabelecimentoEntity.getEndereco());
        showEstabelecimentoDTO.setHorarioAbertura(estabelecimentoEntity.getHorarioAbertura());
        showEstabelecimentoDTO.setHorarioFechamento(estabelecimentoEntity.getHorarioEncerramento());
        showEstabelecimentoDTO.setQuadraList(quadraList);
        showEstabelecimentoDTO.setShowUsuarioDTO(usuarioEntity);
        return showEstabelecimentoDTO;
    }

    @Transactional
    public void deleteEstabelecimentoById(long id) {
        Optional<EstabelecimentoEntity> optionalEstabelecimentoEntity = estabelecimentoRepository.findById(id);

        if (optionalEstabelecimentoEntity.isPresent()) {
            estabelecimentoRepository.deleteById(id);
        } else {
            // throw new deletableException();
        }
    }

    @Transactional
    public void changeEstabelecimentoById(long id, EstabelecimentoDTO dto) {
        Optional<EstabelecimentoEntity> optionalEstabelecimentoEntity = estabelecimentoRepository.findById(id);

        if (optionalEstabelecimentoEntity.isEmpty()) {
            // throw new deletableException();
        } 

        EstabelecimentoEntity estabelecimentoEntity = optionalEstabelecimentoEntity.get();
        estabelecimentoEntity.setCnpj(dto.getCnpj());
        estabelecimentoEntity.setEndereco(dto.getEndereco());
        estabelecimentoEntity.setHorarioAbertura(dto.getHorarioAbertura());
        estabelecimentoEntity.setHorarioEncerramento(dto.getHorarioFechamento());
        estabelecimentoRepository.save(estabelecimentoEntity);
    }

}
