package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.RoleHasPrivileges;

@Repository
public interface RoleHasPrivilegesRepository extends JpaRepository<RoleHasPrivileges, Integer> {

}
