package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoProducto;

public interface IEstadoProductoService {

	void inserta(EstadoProducto estadoProducto);
	void actualiza(EstadoProducto estadoProducto);
	void elimina(EstadoProducto estadoProducto);
		
	EstadoProducto get(int estadoProductoId);
	List<EstadoProducto> list();	
	boolean add(EstadoProducto estadoProducto);
	boolean update(EstadoProducto estadoProducto);
	boolean delete(EstadoProducto estadoProducto);

	Page<EstadoProducto> buscarTodas(Pageable page);
	List<EstadoProducto> buscarTodas();
}
