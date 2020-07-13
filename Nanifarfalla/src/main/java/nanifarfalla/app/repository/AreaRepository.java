package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nanifarfalla.app.model.Area;
//import org.springframework.data.repository.CrudRepository;



public interface AreaRepository extends JpaRepository<Area, Integer> {

}
