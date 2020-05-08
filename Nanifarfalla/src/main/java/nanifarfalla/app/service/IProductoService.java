package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Producto;

public interface IProductoService {
	List<Producto> buscarTodas();
	
	Producto buscarPorId(int idProducto);

	void inserta(Producto producto);
	
	Page<Producto> buscarTodas(Pageable page);
	
}
