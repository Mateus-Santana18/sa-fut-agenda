package fut.agenda.fut_agenda.controllers;

import fut.agenda.fut_agenda.dtos.quadra.QuadraHorarioDTO;
import fut.agenda.fut_agenda.services.QuadraService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/quadra")
@RestController
public class QuadraController {
  private final QuadraService quadraService;

  @GetMapping("/date/{horario}")
  public Collection<QuadraHorarioDTO> getAllByDate(@PathVariable String horario) {
    return quadraService.findAllByHorario(horario);
  }
}
