package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

	@Query(value = "select distinct x.nombre_provincia " +
			 "from provincia as x "+
			 "inner join pais as p on x.fkcodigo_pais = p.codigo_pais "+
			 "where x.fkcodigo_pais = :idPais ", nativeQuery = true)
	List<Provincia> findByPaisIdParamsNative(@Param("idPais") int idPais);
	


}
