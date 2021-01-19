package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import nanifarfalla.app.model.Distrito;



@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {

	
	
	@Query(value = "select  x.codigo_distrito, x.fkcodigo_ciudad, x.nombre_distrito " + "from distrito as x "
			+ "inner join ciudad as c on x.fkcodigo_ciudad = c.codigo_ciudad "
			+ "where c.codigo_ciudad = :idCiudad ", nativeQuery = true)
	List<Distrito> findByCiudadIdParamsNative(@Param("idCiudad") int idCiudad);

	@Query(value = "select d.codigo_distrito, d.fkcodigo_ciudad, d.nombre_distrito from Distrito d where d.fkcodigo_ciudad = ?1", nativeQuery = true)
	List<Distrito> findByFkcodigo_ciudad(int codigo_ciudad);

	@Query("select new nanifarfalla.app.model.Distrito(codigo_distrito, nombre_distrito) from Distrito where mCiudad.codigo_ciudad = :id")
	 List<Distrito> findByCity(@Param("id") int id);

	@Query("select d from Distrito d where d.mCiudad.codigo_ciudad = ?1")
	 List<Distrito> BuscaCiudadporClase(int id);

	@Query("select d from Distrito d where d.mCiudad.codigo_ciudad = :idCiudad")
	 List<Distrito> BuscarCiudadClaseconParam(@Param("idCiudad") int codigo_ciudad);
	
	
	
}
