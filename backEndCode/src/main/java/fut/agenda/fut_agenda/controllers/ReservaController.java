package fut.agenda.fut_agenda.controllers;

import fut.agenda.fut_agenda.dtos.reserva.AddUsuarioReservaDTO;
import fut.agenda.fut_agenda.dtos.reserva.ReservaDTO;
import fut.agenda.fut_agenda.dtos.reserva.ReservaUsuarioDTO;
import fut.agenda.fut_agenda.dtos.reserva.SaveReservaDTO;
import fut.agenda.fut_agenda.entities.ReservaEntity;
import fut.agenda.fut_agenda.entities.ReservaUsuarioEntity;
import fut.agenda.fut_agenda.services.ReservaService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/reserva")
@RestController
public class ReservaController {

  private final ReservaService reservaService;

  @PutMapping("/add/{reservaId}")
  public ReservaDTO addToEmail(@PathVariable Long reservaId, @RequestBody AddUsuarioReservaDTO addUsuarioReservaDTO) {
    return reservaService.addToReserva(reservaId, addUsuarioReservaDTO);
  }

  @PostMapping("/save")
  public ReservaDTO saveReserva(@RequestBody SaveReservaDTO saveReservaDTO) {
    return reservaService.saveReserva(saveReservaDTO);
  }

  @GetMapping("/list-users/{reservaId}")
  public Collection<ReservaUsuarioDTO> getUsersByReserva(
      @PathVariable Long reservaId,
      @RequestParam(value = "textQuery", required = false) String textQuery
  ) {
    return reservaService.getUsersByReserva(reservaId, textQuery);
  }

  @GetMapping("/date/{date}")
  public Collection<ReservaDTO> getAllByDate(@PathVariable String date) {
    return reservaService.getAllByDate(date);
  }
}


