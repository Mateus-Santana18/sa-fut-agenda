package fut.agenda.fut_agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fut.agenda.fut_agenda.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    
}
