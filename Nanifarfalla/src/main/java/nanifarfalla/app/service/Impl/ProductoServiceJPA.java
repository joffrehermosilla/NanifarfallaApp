package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.Producto;
import nanifarfalla.app.repository.ProductoRepository;
import nanifarfalla.app.service.IProductoService;
import nanifarfalla.app.service.UserService;
import nanifarfalla.app.util.Utileria;

@Service
public class ProductoServiceJPA implements IProductoService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProductoServiceJPA.class);

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<Producto> buscarTodas() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto buscarPorId(int idProducto) {
		// TODO Auto-generated method stub
		return productoRepository.getOne(idProducto);
	}

	@Override
	public void inserta(Producto producto, MultipartFile multiPart, MultipartFile multiPart1, MultipartFile multiPart2,
			MultipartFile multiPart3, MultipartFile multiPart4, HttpServletRequest request) {

		if (!multiPart.isEmpty()) {

			String ruta = "/resources/images/productos/0/";
			String rutax = "/resources/images/productos/0/";

			LOGGER.info("rutax: " + rutax);
			String nombreImagen = Utileria.guardarImagenPlus(multiPart, request, rutax);

			producto.setFoto_ruta(nombreImagen);
		}

		if (!multiPart1.isEmpty()) {
			String ruta1 = "/resources/images/productos/1/";
			String rutax1 = "/resources/images/productos/1/";

			LOGGER.info("rutax1: " + rutax1);

			String nombreImagen1 = Utileria.guardarImagenPlus(multiPart1, request, rutax1);

			producto.setFoto_ruta1(nombreImagen1);
		}

		if (!multiPart2.isEmpty()) {

			String ruta2 = "/resources/images/productos/2/";
			String rutax2 = "/resources/images/productos/2/";

			LOGGER.info("rutax2: " + rutax2);

			String nombreImagen2 = Utileria.guardarImagenPlus(multiPart2, request, rutax2);

			producto.setFoto_ruta2(nombreImagen2);
		}
		if (!multiPart3.isEmpty()) {

			String ruta3 = "/resources/images/productos/3/";
			String rutax3 = "/resources/images/productos/3/";

			LOGGER.info("rutax3: " + rutax3);

			String nombreImagen3 = Utileria.guardarImagenPlus(multiPart3, request, rutax3);

			producto.setFoto_ruta3(nombreImagen3);
		}
		if (!multiPart4.isEmpty()) {

			String ruta4 = "/resources/images/productos/4/";
			String rutax4 = "/resources/images/productos/4/";

			LOGGER.info("rutax4: " + rutax4);

			String nombreImagen4 = Utileria.guardarImagenPlus(multiPart4, request, rutax4);

			producto.setFoto_ruta4(nombreImagen4);
		}

		Long i = (long) 0;
		producto.setViews(i);

		Long e = (long) 0;

		producto.setPurchases(e);

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		producto.setVersion(timestamp);
		
		
		

		productoRepository.save(producto);

	}

	@Override
	public Page<Producto> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return productoRepository.findAll(page);
	}

	@Override
	public void inserta(Collection<Producto> productos) {
		// TODO Auto-generated method stub

	}

	@Override
	public Producto get(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Producto product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Producto product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Producto product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> getProductsByParam(String param, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listActiveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getProductoByLinea(int idLinea) {
		// TODO Auto-generated method stub
		return productoRepository.getProductoByLinea(idLinea);
	}

	@Override
	public List<Producto> findByFkcodigo_linea(int codigo_linea) {
		// TODO Auto-generated method stub
		return productoRepository.findByFkcodigo_linea(codigo_linea);
	}

	@Override
	public List<Producto> findByLinea(int id) {
		// TODO Auto-generated method stub
		return productoRepository.findByLinea(id);
	}

	@Override
	public List<Producto> BuscaLineaporClase(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> BuscarLineaClaseconParam(int codig_linea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Producto> buscarporId(int id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	public void eliminar(int idProducto) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(idProducto);
	}

}
