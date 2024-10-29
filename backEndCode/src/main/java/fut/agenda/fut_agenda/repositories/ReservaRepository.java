package fut.agenda.fut_agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fut.agenda.fut_agenda.entities.ReservaEntity;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    
}
