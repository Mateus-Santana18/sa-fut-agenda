package fut.agenda.fut_agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fut.agenda.fut_agenda.entities.OrganizadorEntity;

public interface OrganizadorRepository extends JpaRepository<OrganizadorEntity, Long> {
    
}
