package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.ProductoxPedido;

public interface IProductoxpedidoService {

	List<ProductoxPedido> listAvailable(int productoxPedidoId);
	
	ProductoxPedido getByProductoxPedidoAndClienteTienePedido(int codigoPedidoWebId, int ProductoId);
}
