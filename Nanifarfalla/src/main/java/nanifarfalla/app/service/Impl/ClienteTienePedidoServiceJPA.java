package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.Pedido;
import nanifarfalla.app.repository.ClienteTienePedidoRepository;
import nanifarfalla.app.service.IClienteTienePedidoService;

@Service
public class ClienteTienePedidoServiceJPA implements IClienteTienePedidoService{
	
	@Autowired
	private ClienteTienePedidoRepository clientePedidoRepository;

	@Override
	public List<ClienteTienePedido> findPedido(int idCliente) {
		return clientePedidoRepository.findPedidos(idCliente);
	}

}
