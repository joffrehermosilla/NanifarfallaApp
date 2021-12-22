package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.TipoProducto;

public interface ITipoProductoService {

	void inserta(TipoProducto tipoProducto);
	void actualiza(TipoProducto tipoProducto);
	void elimina(TipoProducto tipoProducto);
		
	TipoProducto get(int tipoProductoId);
	List<TipoProducto> list();	
	boolean add(TipoProducto tipoProducto);
	boolean update(TipoProducto tipoProducto);
	boolean delete(TipoProducto tipoProducto);
		
	Page<TipoProducto> buscarTodas(Pageable page);
	List<TipoProducto> buscarTodas();
}
