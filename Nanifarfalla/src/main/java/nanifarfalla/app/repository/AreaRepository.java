package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Area;
//import org.springframework.data.repository.CrudRepository;


@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

}
