package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

	
	//@Query("select pr.nombre_provincia from provincia as pr INNER JOIN pais as p where pr.fkcodigo_pais = :idPais")
   // List<Provincia> findByPais(@Param("idPais")Integer idPais);
}
