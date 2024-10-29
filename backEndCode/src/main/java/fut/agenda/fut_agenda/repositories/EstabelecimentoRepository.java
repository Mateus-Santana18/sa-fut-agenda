package fut.agenda.fut_agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fut.agenda.fut_agenda.entities.EstabelecimentoEntity;

public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, Long> {
    
}
