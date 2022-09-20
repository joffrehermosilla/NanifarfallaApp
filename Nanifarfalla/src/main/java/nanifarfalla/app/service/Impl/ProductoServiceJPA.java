package nanifarfalla.app.service.Impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Producto;
import nanifarfalla.app.repository.ProductoRepository;
import nanifarfalla.app.service.IProductoService;


@Service
public class ProductoServiceJPA implements IProductoService{

	
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
	public void inserta(Producto producto) {
		productoRepository.save(producto );
		
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
