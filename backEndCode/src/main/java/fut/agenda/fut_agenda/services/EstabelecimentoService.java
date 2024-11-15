package fut.agenda.fut_agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fut.agenda.fut_agenda.dtos.req.EstabelecimentoDTO;
import fut.agenda.fut_agenda.entities.EstabelecimentoEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.EstabelecimentoRepository;

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

}
