package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaMenuRoles;

@Repository
public interface AuditoriaMenuRolesRepository extends JpaRepository<AuditoriaMenuRoles, Integer> {

}
