package fut.agenda.fut_agenda.repositories;

import fut.agenda.fut_agenda.dtos.quadra.QuadraHorarioProjection;
import fut.agenda.fut_agenda.entities.QuadraEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuadraRepository extends JpaRepository<QuadraEntity, Long> {

  @Query(value = """
        select
            q.id,
            e.endereco,
            q.nome,
            r.id as reservaId,
            :horario as horario
        from quadra q
            left join estabelecimento e on e.id = q.id_estabelecimento
            left join public.reserva r on q.id = r.id_quadra and r.horario = :horario
      """, nativeQuery = true)
  List<QuadraHorarioProjection> findAllByHorario(String horario);
}
