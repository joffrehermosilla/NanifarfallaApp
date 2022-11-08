package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.ClienteTienePedido;

public interface IClienteTienePedidoService {

	List<ClienteTienePedido> findPedido(int idCliente);

	List<ClienteTienePedido> buscarTodas();

	void guardar(ClienteTienePedido clienteTienePedido);

	// Anuncio buscarporId(int idAnuncio);

	void inserta(ClienteTienePedido clienteTienePedido, MultipartFile multiPart, HttpServletRequest request);

	void insertar(ClienteTienePedido clienteTienePedido);

	void actualiza(ClienteTienePedido clienteTienePedido);

	void elimina(ClienteTienePedido clienteTienePedido);

	void eliminar(int idAnuncio);

	Optional<ClienteTienePedido> buscarporId(int id);

	ClienteTienePedido get(int clienteTienePedidoId);

	List<ClienteTienePedido> list();

	boolean add(ClienteTienePedido clienteTienePedido);

	boolean update(ClienteTienePedido clienteTienePedido);

	boolean delete(ClienteTienePedido clienteTienePedido);

	Page<ClienteTienePedido> buscarTodas(Pageable page);

}
