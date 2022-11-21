package nanifarfalla.app.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	public List<ProductoxPedido> buscarTodas() {
		// TODO Auto-generated method stub
		return productoxPedidoRepository.findAll();
	}

	@Override
	public void guardar(ProductoxPedido productoxPedido) {
		// TODO Auto-generated method stub
		productoxPedidoRepository.save(productoxPedido);
	}

	@Override
	public void inserta(ProductoxPedido productoxPedido, MultipartFile multiPart, HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualiza(ProductoxPedido productoxPedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(ProductoxPedido productoxPedido) {
		// TODO Auto-generated method stub
		productoxPedidoRepository.delete(productoxPedido);
	}

	@Override
	public void eliminar(int idAnuncio) {
		// TODO Auto-generated method stub
		productoxPedidoRepository.deleteById(idAnuncio);
	}

	@Override
	public Optional<ProductoxPedido> buscarporId(int id) {
		// TODO Auto-generated method stub
		return productoxPedidoRepository.findById(id);
	}

	@Override
	public ProductoxPedido get(int clienteTienePedidoId) {
		// TODO Auto-generated method stub
		return productoxPedidoRepository.getOne(clienteTienePedidoId);
	}

	@Override
	public List<ProductoxPedido> list() {
		// TODO Auto-generated method stub
		return productoxPedidoRepository.findAll();
	}

	@Override
	public boolean add(ProductoxPedido productoxPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ProductoxPedido productoxPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProductoxPedido productoxPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<ProductoxPedido> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ProductoxPedido productoxPedido) {
		// TODO Auto-generated method stub
		productoxPedidoRepository.save(productoxPedido);
	}

	@Override
	public List<ProductoxPedido> list(int pedidoId) {
		// TODO Auto-generated method stub
		return productoxPedidoRepository.list(pedidoId);
	}

}
