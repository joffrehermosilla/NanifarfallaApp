package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.ClienteTienePedido;

public interface IClienteTienePedidoService {
	List<ClienteTienePedido> findPedido(int idCliente);
}
