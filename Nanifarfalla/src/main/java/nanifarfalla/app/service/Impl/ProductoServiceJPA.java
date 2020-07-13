package nanifarfalla.app.service.Impl;

import java.util.Collection;
import java.util.List;

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
		return null;
	}

	@Override
	public Producto buscarPorId(int idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserta(Producto producto) {
		productoRepository.save(producto );
		
	}

	@Override
	public Page<Producto> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserta(Collection<Producto> productos) {
		// TODO Auto-generated method stub
		
	}

}
