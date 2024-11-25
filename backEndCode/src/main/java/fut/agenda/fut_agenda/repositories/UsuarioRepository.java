package fut.agenda.fut_agenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fut.agenda.fut_agenda.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    
    Optional<UsuarioEntity> findByEmail(String email);

}
