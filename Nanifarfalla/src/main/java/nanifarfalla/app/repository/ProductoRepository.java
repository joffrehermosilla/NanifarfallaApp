package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Producto;





@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query(value = "select  x.codigo_producto, x.fkcodigo_linea, x.nombre_producto, x.pvv_producto " + "from producto as x "
			+ "inner join linea as l on x.fkcodigo_linea = l.codigo_linea "
			+ "where l.codigo_linea = :idLinea ", nativeQuery = true)
	List<Producto> getProductoByLinea(@Param("idLinea") int idLinea);

	
	
	@Query(value = "select p.codigo_producto, p.fkcodigo_linea, p.nombre_producto from producto p where p.fkcodigo_linea = ?1", nativeQuery = true)
	List<Producto> findByFkcodigo_linea(int codigo_linea);
	
	
	  @Query("select new nanifarfalla.app.model.Producto(codigo_producto, nombre_producto) from Producto where mLinea.codigo_linea = :id"
	  ) List<Producto> findByLinea(@Param("id") int id);
	 
	
	@Query("select p from Producto p where p.mLinea.codigo_linea = ?1")
	List<Producto> BuscaLineaporClase(int id);
	
	
	@Query("select p from Producto p where p.mLinea.codigo_linea = :idLinea")
	List<Producto> BuscarLineaClaseconParam(@Param("idLinea") int codig_linea);
	
//	List<Producto> getMostViewedProducts(@Param("views") int views);

//	List<Producto> getMostPurchasedProducts(@Param("views") int views);

}
