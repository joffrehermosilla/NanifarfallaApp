package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
