package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.Pedido;

public interface IClienteTienePedidoService {
	List<ClienteTienePedido> findPedido(int idCliente);
}
