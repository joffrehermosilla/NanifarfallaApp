package nanifarfalla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.ProductoxPedido;

@Repository
public interface ProductoxPedidoRepository extends JpaRepository<ProductoxPedido, Integer> {

	@Query("select p from ProductoxPedido p where p.mClientetienepedido.codigo_pedido_web = :pedidoId "
			+ "AND p.mProducto.codigo_producto = :productoId ")
	List<ProductoxPedido> getByProductoxPedidoAndClienteTienePedido(@Param("pedidoId") int pedidoId,
			@Param("productoId") int productoId);
	
	

	@Query("select p from ProductoxPedido p where p.mClientetienepedido.codigo_pedido_web = :pedidoId ")
	List<ProductoxPedido> list(@Param("pedidoId") int pedidoId);

}
