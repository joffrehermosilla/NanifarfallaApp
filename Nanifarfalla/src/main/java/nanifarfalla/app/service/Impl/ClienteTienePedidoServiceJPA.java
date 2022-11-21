package nanifarfalla.app.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.ClienteTienePedido;

import nanifarfalla.app.repository.ClienteTienePedidoRepository;
import nanifarfalla.app.service.IClienteTienePedidoService;

@Service
public class ClienteTienePedidoServiceJPA implements IClienteTienePedidoService {

	@Autowired
	private ClienteTienePedidoRepository clientePedidoRepository;

	@Override
	public List<ClienteTienePedido> findPedido(int idCliente) {
		return clientePedidoRepository.findPedidos(idCliente);
	}

	@Override
	public List<ClienteTienePedido> buscarTodas() {
		// TODO Auto-generated method stub
		return clientePedidoRepository.findAll();
	}

	@Override
	public void guardar(ClienteTienePedido clienteTienePedido) {
		// TODO Auto-generated method stub
		clientePedidoRepository.save(clienteTienePedido);
	}

	@Override
	public void inserta(ClienteTienePedido clienteTienePedido, MultipartFile multiPart, HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualiza(ClienteTienePedido clienteTienePedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(ClienteTienePedido clienteTienePedido) {
		// TODO Auto-generated method stub
		clientePedidoRepository.delete(clienteTienePedido);
	}

	@Override
	public void eliminar(int idAnuncio) {
		// TODO Auto-generated method stub
		clientePedidoRepository.deleteById(idAnuncio);
	}

	@Override
	public Optional<ClienteTienePedido> buscarporId(int id) {
		// TODO Auto-generated method stub
		return clientePedidoRepository.findById(id);
	}

	@Override
	public ClienteTienePedido get(int clienteTienePedidoId) {
		// TODO Auto-generated method stub
		return clientePedidoRepository.getOne(clienteTienePedidoId);
	}

	@Override
	public List<ClienteTienePedido> list() {
		// TODO Auto-generated method stub
		return clientePedidoRepository.findAll();
	}

	@Override
	public boolean add(ClienteTienePedido clienteTienePedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ClienteTienePedido clienteTienePedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ClienteTienePedido clienteTienePedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<ClienteTienePedido> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ClienteTienePedido clienteTienePedido) {
		// TODO Auto-generated method stub
		clientePedidoRepository.save(clienteTienePedido);
	}

}
