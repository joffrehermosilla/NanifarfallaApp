package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.Pedido;



@Repository
public interface ClienteTienePedidoRepository extends JpaRepository<ClienteTienePedido, Integer> {
	
	@Query(value = "select * "
			+ "from cliente_tiene_pedido ctp "
			+ "inner join usuario u 			  	 	  on u.codigo_usuario=ctp.fkcodigo_usuario "
			+ "inner join factura_c_tiene_pedido fc 	  on fc.codigo_factura_cliente_tiene_pedido=ctp.fkcodigo_factura_cliente_tiene_pedido "
			+ "inner join estado_cliente_tiene_pedido ec  on ec.codigo_estado_cliente_tiene_pedido=ctp.fkcodigo_estado_cliente_tiene_pedido "
			+ "inner join cliente c 			  	 	  on c.codigo_cliente=ctp.fkcodigo_cliente "
			+ "where u.codigo_usuario=:idCliente ", nativeQuery = true)
	List<ClienteTienePedido> findPedidos(@Param("idCliente") int idCliente);	
	
	
	@Query(value = "select p.nombre_producto, p.foto_ruta, l.nombre_linea, p.stock_producto, pxp.cantidad_producto, pxp.valor_con_igv, pxp.valor_neto, ctp.cantidad_producto, u.nombre_usuario, u.apellido_usuario, u.email"
			+ "from cliente_tiene_pedido ctp "
			+ "inner join usuario u 			  	 	  on u.codigo_usuario=ctp.fkcodigo_usuario "
			+ "inner join producto_por_pedido pxp           on ctp.codigo_pedido_web = pxp.fkcodigo_pedido_web "
			+ "inner join producto p  on 	 p.codigo_producto = pxp.fkcodigo_producto "
			+ "inner join linea l on 	 l.codigo_linea = p.fkcodigo_linea "
			+ "where u.codigo_usuario=:idCliente ", nativeQuery = true)
	List<ClienteTienePedido> findPedidosCart(@Param("idCliente") int idCliente);	
	
	/*x
	 * @Query(value =u
	 * "select  x.codigo_pedido_web, x.fkcodigo_suario, x.fkcodigo_cliente, x.fkcodigo_vendedor, x.fkcodigo_igv_venta,  x.fkcodigo_promocion_venta, "
	 * +
	 * "x.fkcodigo_estado_cliente_tiene_pedido, x.fkcodigo_factura_cliente_tiene_pedido, x.descuento_web_pedido, x.precio_uni_desc_igv, x.precio_uni_desc_sin_igv, x.fecha_pedido, x.fecha_entrega, "
	 * +"x.cantidad_producto, x.monto_por_descuento " + "from producto as x " +
	 * "inner join usuario as u on x.fkcodigo_usuario = u.codigo_usuario " +
	 * "inner join cliente as c on x.fkcodigo_cliente = c.codigo_cliente " +
	 * "inner join vendedor as v on x.fkcodigo_vendedor = v.codigo_vendedor " +
	 * "inner join igv_venta as i on x.fkcodigo_igv_venta = i.codigo_igv_venta " +
	 * "inner join promocion_venta as p on x.fkcodigo_promocion_venta = p.codigo_promocion_venta "
	 * +
	 * "inner join estado_cliente_tiene_pedido as e on x.fkcodigo_estado_cliente_tiene_pedido = e.codigo_estado_cliente_tiene_pedido "
	 * +
	 * "inner join factura_c_tiene_pedido as f on x.fkcodigo_factura_cliente_tiene_pedido = f.codigo_factura_cliente_tiene_pedido "
	 * + "where u.codigo_usuario = :idUsuario ", nativeQuery = true)
	 * List<ClienteTienePedido> getPedidotieneProductos(@Param("idUsuario") int
	 * idUsuario);
	 * 
	 * 
	 * 
	 * @Query(value =
	 * "select p.codigo_producto, p.fkcodigo_linea, p.nombre_producto from Producto p where p.fkcodigo_linea = ?1"
	 * , nativeQuery = true) List<ClienteTienePedido> findByFkcodigo_linea(int
	 * codigo_linea);
	 * 
	 * 
	 * @Query("select new nanifarfalla.app.model.Producto(codigo_producto, nombre_producto) from Producto where mLinea.codigo_linea = :id"
	 * ) List<ClienteTienePedido> findByLinea(@Param("id") int id);
	 * 
	 * 
	 * @Query("select p from Producto p where p.mLinea.codigo_linea = ?1")
	 * List<ClienteTienePedido> BuscaLineaporClase(int id);
	 * 
	 * 
	 * @Query("select p from Producto p where p.mLinea.codigo_linea = :idLinea")
	 * List<ClienteTienePedido> BuscarLineaClaseconParam(@Param("idLinea") int
	 * codig_linea);
	 */
	
	
}
