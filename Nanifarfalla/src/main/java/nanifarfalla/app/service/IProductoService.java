package nanifarfalla.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import nanifarfalla.app.model.Producto;

public interface IProductoService {
	List<Producto> buscarTodas();
	
	Producto buscarPorId(int idProducto);

	void inserta(Producto producto);
	
	void inserta(Collection<Producto> productos);
	
	Page<Producto> buscarTodas(Pageable page);
	void eliminar(int idProducto);
	List<Producto> getProductoByLinea( int idLinea);
	List<Producto> findByFkcodigo_linea(int codigo_linea);
	List<Producto> findByLinea(int id);
	List<Producto> BuscaLineaporClase(int id);
	List<Producto> BuscarLineaClaseconParam(int codig_linea);
	Optional<Producto> buscarporId(int id);
	Producto get(int productId);
	List<Producto> list();	
	boolean add(Producto product);
	boolean update(Producto product);
	boolean delete(Producto product);

	List<Producto> getProductsByParam(String param, int count);	
	
	
	// business methods
	List<Producto> listActiveProducts();	
	List<Producto> listActiveProductsByCategory(int categoryId);
	List<Producto> getLatestActiveProducts(int count);
	
	
	
}
