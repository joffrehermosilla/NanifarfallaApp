package nanifarfalla.app.service;

import java.util.List;



import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.Producto;

public interface ILineasService  {
	
	List<Linea> buscarTodas();
	
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
	
}
