package fut.agenda.fut_agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.req.QuadraDTO;
import fut.agenda.fut_agenda.dtos.res.ShowEstabelecimentoDTO;
import fut.agenda.fut_agenda.dtos.res.ShowQuadraDTO;
import fut.agenda.fut_agenda.entities.EstabelecimentoEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.repositories.QuadraRepository;

@Service
public class QuadraService {
    

    @Autowired
    QuadraRepository quadraRepository;

    public void criarQuadra ( QuadraDTO dto) {

        QuadraEntity quadraEntity = new QuadraEntity();

        quadraEntity.setId(dto.getId());
        quadraEntity.setTipo(dto.getTipo());

        final QuadraEntity quadraEntityPersistance = quadraRepository.save(quadraEntity);

        EstabelecimentoEntity estabelecimentoEntity = new EstabelecimentoEntity();
        estabelecimentoEntity.setId(dto.getId());

        quadraEntityPersistance.setEstabelecimentoEntity(estabelecimentoEntity);
        
    }

    public List<ShowQuadraDTO> listarQuadras () {
        List<QuadraEntity> quadraEntities = quadraRepository.findAll();

        return quadraEntities.stream().map(quadra -> {
            ShowQuadraDTO showQuadraDTO = new ShowQuadraDTO();

            showQuadraDTO.setId(quadra.getId());
            showQuadraDTO.setTipo(quadra.getTipo());

            ShowEstabelecimentoDTO showEstabelecimentoDTO = new ShowEstabelecimentoDTO();
            showEstabelecimentoDTO.setCnpj(quadra.getTipo());
            
            showQuadraDTO.setIdEstabelecimento(quadra.getEstabelecimentoEntity().getId());

            return showQuadraDTO;
        }).toList();
    }


}
