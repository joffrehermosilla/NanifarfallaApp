package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.MenuRoles;


@Repository
public interface MenuRolesRepository extends JpaRepository<MenuRoles, Integer> {

}
