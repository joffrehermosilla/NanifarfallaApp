package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.MenuV1;

@Repository
public interface MenuV1Repository extends JpaRepository<MenuV1, Integer> {

}
