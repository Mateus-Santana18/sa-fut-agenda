package fut.agenda.fut_agenda.repositories;

import fut.agenda.fut_agenda.entities.ReservaEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

  @Query(value = """
        select r from reserva r where r.horario = :horario and r.quadraEntity.id = :quadraId
      """)
  Optional<ReservaEntity> findByQuadraAndHorario(@Param("horario") String horario, @Param("quadraId") Long quadraId);

  @Query(value = """
      select r from reserva r where r.horario like %?1%
  """)
  List<ReservaEntity> findAllByDate(@Param("data") String data);

}
