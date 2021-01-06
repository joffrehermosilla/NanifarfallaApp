package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Distrito;



@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {

	//@Query("select d.nombre_distrito from distrito as d INNER JOIN ciudad as c where d.fkcodigo_ciudad = :CiudadId")
    //List<Distrito> findByCiudad(@Param("CiudadId")Integer CiudadId);
}
