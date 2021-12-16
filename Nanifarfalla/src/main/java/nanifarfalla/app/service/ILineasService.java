package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.Producto;

public interface ILineasService  {

	
	Linea buscarPorId(int idLinea);

	void inserta(Linea linea);
	List<Producto> findProductobyLineaIdParamsNative(int idLinea);
	List<Linea> findBycodigo_linea(int codigo_linea);
	List<Linea> findByid_linea( int id);
	
	
	Linea get(int id);
	List<Linea> list();
	boolean add(Linea category);
	boolean update(Linea category);
	boolean delete(Linea category);
	
	
	
	//Siempre agregar la paginación
	Page<Linea> buscarTodas(Pageable page);
	List<Linea> buscarTodas();
	
}
