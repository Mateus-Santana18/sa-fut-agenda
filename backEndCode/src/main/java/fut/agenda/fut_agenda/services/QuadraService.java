package fut.agenda.fut_agenda.services;

import fut.agenda.fut_agenda.dtos.quadra.QuadraDTO;
import fut.agenda.fut_agenda.dtos.quadra.QuadraHorarioDTO;
import fut.agenda.fut_agenda.dtos.quadra.QuadraHorarioProjection;
import fut.agenda.fut_agenda.entities.EstabelecimentoEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.repositories.EstabelecimentoRepository;
import fut.agenda.fut_agenda.repositories.QuadraRepository;
import java.util.Collection;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuadraService {

  private final QuadraRepository quadraRepository;
  private final EstabelecimentoRepository estabelecimentoRepository;

  public Collection<QuadraHorarioDTO> findAllByHorario(String horario) {
    Collection<QuadraHorarioProjection> quadraHorarioDTOS = quadraRepository.findAllByHorario(
        horario);
    return quadraHorarioDTOS.stream()
        .map(q -> QuadraHorarioDTO
            .builder()
            .reservaId(q.getReservaId())
            .nome(q.getNome())
            .id(q.getId())
            .endereco(q.getEndereco())
            .horario(q.getHorario())
            .build()).toList();
  }

  public QuadraDTO save(QuadraDTO quadraDTO) {
    if (Objects.isNull(quadraDTO.getNome())) {
      throw new RuntimeException("Campo nome não preenchido");
    }

    if (Objects.isNull(quadraDTO.getTipo())) {
      throw new RuntimeException("Campo tipo não preenchido");
    }

    EstabelecimentoEntity estabelecimentoEntity = estabelecimentoRepository
        .findAll()
        .stream()
        .findFirst()
        .orElseThrow();

    QuadraEntity quadraEntity = QuadraEntity
        .builder()
        .estabelecimentoEntity(estabelecimentoEntity)
        .nome(quadraDTO.getNome())
        .tipo(quadraDTO.getTipo())
        .build();
    quadraEntity = quadraRepository.save(quadraEntity);

    quadraDTO.setId(quadraEntity.getId());
    return quadraDTO;
  }

  public Collection<QuadraDTO> getAll() {
    return quadraRepository
        .findAll()
        .stream()
        .map(e -> QuadraDTO
            .builder()
            .idEstabelecimento(e.getEstabelecimentoEntity().getId())
            .tipo(e.getTipo())
            .nome(e.getNome())
            .build()
        ).toList();
  }
}
