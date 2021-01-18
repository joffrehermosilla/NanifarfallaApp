package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Ciudad;




@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

	@Query(value = "select  x.codigo_ciudad, x.fkcodigo_provincia, x.nombre_ciudad " + "from ciudad as x "
			+ "inner join provincia as p on x.fkcodigo_provincia = p.codigo_provincia "
			+ "where p.codigo_provincia = :idProvincia ", nativeQuery = true)
	List<Ciudad> findByProvinciaIdParamsNative(@Param("idProvincia") int idProvincia);

	@Query(value = "select c.codigo_ciudad, c.fkcodigo_provincia, c.nombre_ciudad from Ciudad c where c.fkcodigo_provincia = ?1", nativeQuery = true)
	List<Ciudad> findByFkcodigo_provincia(int codigo_provincia);

	@Query("select new nanifarfalla.app.model.Ciudad(codigo_ciudad, nombre_ciudad) from Ciudad where mProvincia.codigo_provincia = :id")
	 List<Ciudad> findByState(@Param("id") int id);

	@Query("select c from Ciudad c where c.mProvincia.codigo_provincia = ?1")
	 List<Ciudad> BuscaProvinciaporClase(int id);

	@Query("select c from Ciudad c where c.mProvincia.codigo_provincia = :idProvincia")
	 List<Ciudad> BuscarProvinciaClaseconParam(@Param("idProvincia") int codig_provincia);
	
}
