package fut.agenda.fut_agenda.services;

import fut.agenda.fut_agenda.dtos.reserva.AddUsuarioReservaDTO;
import fut.agenda.fut_agenda.dtos.reserva.ReservaDTO;
import fut.agenda.fut_agenda.dtos.reserva.ReservaUsuarioDTO;
import fut.agenda.fut_agenda.dtos.reserva.SaveReservaDTO;
import fut.agenda.fut_agenda.dtos.usuario.UsuarioDTO;
import fut.agenda.fut_agenda.entities.Funcao;
import fut.agenda.fut_agenda.entities.OrganizadorEntity;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import fut.agenda.fut_agenda.entities.ReservaEntity;
import fut.agenda.fut_agenda.entities.ReservaUsuarioEntity;
import fut.agenda.fut_agenda.entities.UsuarioEntity;
import fut.agenda.fut_agenda.repositories.QuadraRepository;
import fut.agenda.fut_agenda.repositories.ReservaRepository;
import fut.agenda.fut_agenda.repositories.UsuarioRepository;
import fut.agenda.fut_agenda.util.SecurityUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservaService {

  private final ReservaRepository reservaRepository;
  private final QuadraRepository quadraRepository;
  private final UsuarioRepository usuarioRepository;

  public ReservaDTO saveReserva(SaveReservaDTO saveReservaDTO) {
    Long quadraId = saveReservaDTO.getQuadraId();
    String horario = saveReservaDTO.getHorario();
    Funcao funcao = saveReservaDTO.getFuncao();

    QuadraEntity quadraEntity = quadraRepository.findById(quadraId).orElseThrow();
    Optional<ReservaEntity> reservaEntity = reservaRepository.findByQuadraAndHorario(horario,
        quadraId);
    if (reservaEntity.isPresent()) {
      throw new RuntimeException("Reserva já existe");
    }

    UsuarioEntity usuarioEntity = SecurityUtils.getCurrentUser();
    OrganizadorEntity organizadorEntity = OrganizadorEntity
        .builder()
        .usuarioEntity(usuarioEntity)
        .build();
    ReservaEntity reserva = ReservaEntity
        .builder()
        .horario(horario)
        .quadraEntity(quadraEntity)
        .organizadorEntity(organizadorEntity)
        .build();
    ReservaEntity reservaSaved = reservaRepository.save(reserva);
    ReservaUsuarioEntity reservaUsuarioEntity = ReservaUsuarioEntity
        .builder()
        .reservaEntity(reserva)
        .usuarioEntity(usuarioEntity)
        .funcao(funcao)
        .build();
    reservaSaved.setReservaUsuarioEntitySet(new HashSet<>(Set.of(reservaUsuarioEntity)));
    return this.toReservaDTO(reservaRepository.save(reservaSaved));
  }

  public ReservaDTO addToReserva(Long reservaId, AddUsuarioReservaDTO addUsuarioReservaDTO) {
    ReservaEntity reservaEntity = reservaRepository.findById(reservaId).orElseThrow();
    UsuarioEntity userForAdd = usuarioRepository.findByEmail(addUsuarioReservaDTO.getEmail())
        .orElseThrow();
    if (reservaEntity.getReservaUsuarioEntitySet().stream()
        .anyMatch(ru -> ru.getUsuarioEntity().getId() == userForAdd.getId())) {
      throw new RuntimeException("Usuario já foi adicionado na reserva");
    }

    Set<ReservaUsuarioEntity> users = reservaEntity.getReservaUsuarioEntitySet();
    ReservaUsuarioEntity reservaUsuarioEntity = ReservaUsuarioEntity
        .builder()
        .reservaEntity(reservaEntity)
        .usuarioEntity(userForAdd)
        .funcao(addUsuarioReservaDTO.getFuncao())
        .build();
    users.add(reservaUsuarioEntity);

    reservaEntity.setReservaUsuarioEntitySet(users);
    return this.toReservaDTO(reservaRepository.save(reservaEntity));
  }

  public Collection<ReservaUsuarioDTO> getUsersByReserva(Long reservaId, String textQuery) {
    return reservaRepository.findById(reservaId)
        .orElseThrow()
        .getReservaUsuarioEntitySet()
        .stream()
        .map(ru -> {
          ReservaDTO reservaDTO = this.toReservaDTO(ru.getReservaEntity());
          UsuarioDTO usuarioDTO = UsuarioDTO
              .builder()
              .id(ru.getUsuarioEntity().getId())
              .nome(ru.getUsuarioEntity().getNome())
              .email(ru.getUsuarioEntity().getEmail())
              .telefone(ru.getUsuarioEntity().getTelefone())
              .build();
          return ReservaUsuarioDTO
              .builder()
              .funcao(ru.getFuncao())
              .reserva(reservaDTO)
              .adminId(ru.getReservaEntity().getOrganizadorEntity().getUsuarioEntity().getId())
              .usuario(usuarioDTO)
              .build();
        })
        .filter(e -> {
//          if (textQuery == null || textQuery.trim().isEmpty()) {
            return true;
//          }
//          return e.getUsuario().getEmail().contains(textQuery);
        })
        .toList();
  }

  public Collection<ReservaDTO> getAllByDate(String date) {
    List<ReservaEntity> reservaEntityList = reservaRepository.findAllByDate(date);
    return reservaEntityList
        .stream()
        .map(this::toReservaDTO)
        .toList();
  }

  private ReservaDTO toReservaDTO(ReservaEntity reservaEntity) {
    return ReservaDTO
        .builder()
        .horario(reservaEntity.getHorario())
        .name(reservaEntity.getHorario())
        .id(reservaEntity.getId())
        .build();
  }
}
