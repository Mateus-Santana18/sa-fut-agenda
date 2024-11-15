package fut.agenda.fut_agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.req.QuadraDTO;
import fut.agenda.fut_agenda.dtos.req.UsuarioDTO;
import fut.agenda.fut_agenda.dtos.res.ShowEstabelecimentoDTO;
import fut.agenda.fut_agenda.dtos.res.ShowQuadraDTO;
import fut.agenda.fut_agenda.entities.EstabelecimentoEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.repositories.QuadraRepository;
import jakarta.transaction.Transactional;

@Service
public class QuadraService {

    @Autowired
    QuadraRepository quadraRepository;

    public void criarQuadra(QuadraDTO dto) {

        QuadraEntity quadraEntity = new QuadraEntity();

        quadraEntity.setId(dto.getId());
        quadraEntity.setTipo(dto.getTipo());

        EstabelecimentoEntity estabelecimentoEntity = new EstabelecimentoEntity();
        estabelecimentoEntity.setId(dto.getId());

        quadraEntity.setEstabelecimentoEntity(estabelecimentoEntity);

        quadraRepository.save(quadraEntity);

    }

    public List<ShowQuadraDTO> listarQuadras() {
        List<QuadraEntity> quadraEntities = quadraRepository.findAll();

        return quadraEntities.stream().map(quadra -> {
            ShowQuadraDTO showQuadraDTO = new ShowQuadraDTO();

            showQuadraDTO.setId(quadra.getId());
            showQuadraDTO.setTipo(quadra.getTipo());

            ShowEstabelecimentoDTO showEstabelecimentoDTO = new ShowEstabelecimentoDTO();
            showEstabelecimentoDTO.setEndereco(quadra.getEstabelecimentoEntity().getEndereco());
            showEstabelecimentoDTO.setHorarioAbertura(quadra.getEstabelecimentoEntity().getHorarioAbertura());
            showEstabelecimentoDTO.setHorarioFechamento(quadra.getEstabelecimentoEntity().getHorarioEncerramento());

            showQuadraDTO.setShowEstabelecimentoDTO(showEstabelecimentoDTO);

            return showQuadraDTO;
        }).toList();
    }

    public ShowQuadraDTO getQuadraById(long id) {
        Optional<QuadraEntity> optionalQuadraEntity = quadraRepository.findById(id);

        if (optionalQuadraEntity.isEmpty()) {
            // Joga uma excecao
            return new ShowQuadraDTO();
        }

        QuadraEntity quadraEntity = optionalQuadraEntity.get();

        ShowQuadraDTO quadraDTO = new ShowQuadraDTO();
        quadraDTO.setId(quadraEntity.getId());
        quadraDTO.setTipo(quadraEntity.getTipo());

        ShowEstabelecimentoDTO showEstabelecimentoDTO = new ShowEstabelecimentoDTO();
        showEstabelecimentoDTO.setEndereco(quadraEntity.getEstabelecimentoEntity().getEndereco());
        showEstabelecimentoDTO.setHorarioAbertura(quadraEntity.getEstabelecimentoEntity().getHorarioAbertura());
        showEstabelecimentoDTO.setHorarioFechamento(quadraEntity.getEstabelecimentoEntity().getHorarioEncerramento());

        quadraDTO.setShowEstabelecimentoDTO(showEstabelecimentoDTO);

        return quadraDTO;
    }

    @Transactional
    public void deleteQuadraById(long id) {

        Optional<QuadraEntity> optionalQuadraEntity = quadraRepository.findById(id);

        if (optionalQuadraEntity.isPresent()) {
            quadraRepository.deleteById(id);
        } else {
            // throw new deletableException();
        }
    }

    @Transactional
    public void changeQuadraById(long id, UsuarioDTO dto) {
        Optional<QuadraEntity> optionalQuadraEntity = quadraRepository.findById(id);

        if (optionalQuadraEntity.isEmpty()) {
            // jogar uma excecao
        }

        QuadraEntity quadraEntity = optionalQuadraEntity.get();

        quadraEntity.setTipo(quadraEntity.getTipo());

        quadraRepository.save(quadraEntity);
    }

}
