package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.ProductoxPedido;

public interface IProductoxpedidoService {

	List<ProductoxPedido> listAvailable(int productoxPedidoId);

	ProductoxPedido getByProductoxPedidoAndClienteTienePedido(int codigoPedidoWebId, int ProductoId);

	List<ProductoxPedido> buscarTodas();

	void guardar(ProductoxPedido productoxPedido);

	// Anuncio buscarporId(int idAnuncio);

	void inserta(ProductoxPedido productoxPedido, MultipartFile multiPart, HttpServletRequest request);

	void insertar(ProductoxPedido productoxPedido);

	void actualiza(ProductoxPedido productoxPedido);

	void elimina(ProductoxPedido productoxPedido);

	void eliminar(int idAnuncio);

	Optional<ProductoxPedido> buscarporId(int id);

	ProductoxPedido get(int clienteTienePedidoId);

	List<ProductoxPedido> list();

	boolean add(ProductoxPedido productoxPedido);

	boolean update(ProductoxPedido productoxPedido);

	boolean delete(ProductoxPedido productoxPedido);

	Page<ProductoxPedido> buscarTodas(Pageable page);
}
