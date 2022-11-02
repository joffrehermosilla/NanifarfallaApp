package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.ProductoxPedido;
import nanifarfalla.app.repository.ClienteTienePedidoRepository;
import nanifarfalla.app.repository.ProductoxPedidoRepository;
import nanifarfalla.app.service.IProductoxpedidoService;

@Service
public class ProductoxPedidoServiceJPA implements IProductoxpedidoService {

	@Autowired
	ProductoxPedidoRepository productoxPedidoRepository;
	
	@Autowired
	ClienteTienePedidoRepository clienteTienePedidoRepository;
	
	
	
	@Override
	public List<ProductoxPedido> listAvailable(int productoxPedidoId) {
		// TODO Auto-generated method stub
		return productoxPedidoRepository.findAll();
	}

	@Override
	public ProductoxPedido getByProductoxPedidoAndClienteTienePedido(int codigoPedidoWebId, int ProductoId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
