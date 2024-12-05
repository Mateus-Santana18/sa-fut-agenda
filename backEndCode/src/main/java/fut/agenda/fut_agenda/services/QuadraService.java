package fut.agenda.fut_agenda.services;

import fut.agenda.fut_agenda.dtos.quadra.QuadraHorarioDTO;
import fut.agenda.fut_agenda.dtos.quadra.QuadraHorarioProjection;
import fut.agenda.fut_agenda.repositories.QuadraRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuadraService {

  private final QuadraRepository quadraRepository;

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
}
