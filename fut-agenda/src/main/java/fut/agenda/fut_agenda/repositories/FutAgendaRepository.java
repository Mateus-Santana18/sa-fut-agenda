package fut.agenda.fut_agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fut.agenda.fut_agenda.entities.UsuarioFutAgendaEntity;

public interface FutAgendaRepository extends JpaRepository <UsuarioFutAgendaEntity, Long> {
    
}
