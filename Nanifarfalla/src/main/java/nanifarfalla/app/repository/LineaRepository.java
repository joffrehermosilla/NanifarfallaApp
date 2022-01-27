package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.Producto;


@Repository
public interface LineaRepository extends JpaRepository<Linea, Integer> {
	@Query(value = "select  x.codigo_producto, x.nombre_producto, x.stock_producto, x.pvv_producto "
			+ "from producto as x " + "inner join linea as l on l.codigo_linea = x.fkcodigo_linea "
			+ "where l.codigo_linea = :idLinea", nativeQuery = true)
	List<Producto> findProductobyLineaIdParamsNative(@Param("idLinea") int idLinea);

	
	
	@Query(value = "CONCAT( u.codigo_usuario,\"/\", k.codigo_contrato,\"/\",c.codigo_cliente)"
			+ "FROM usuario u" 
			+ "INNER JOIN contrato k ON k.fkcodigo_usuario = u.codigo_usuario "
			+ "INNER JOIN cliente c ON c.codigo_cliente = k.fkcodigo_cliente "
			+ "where u.email = :usernamex", nativeQuery = true)
	String findRutaFicheroSesion(@Param("usernamex") String usernamex);
	
	
	
	
	@Query(value = "select l.codigo_linea, l.nombre_linea, l.foto_linea from linea l where l.codigo_linea = ?1", nativeQuery = true)
	List<Linea> findBycodigo_linea(int codigo_linea);

	@Query("select new nanifarfalla.app.model.Linea(codigo_linea, nombre_linea) from Linea where codigo_linea = :id")
	List<Linea> findByid_linea(@Param("id") int id);

}
