package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Colores;

public interface IColoresService {

	void inserta(Colores colores);
	void actualiza(Colores colores);
	void elimina(Colores colores);
		
	Colores get(int coloresId);
	List<Colores> list();	
	boolean add(Colores colores);
	boolean update(Colores colores);
	boolean delete(Colores colores);
		
	Page<Colores> buscarTodas(Pageable page);
	List<Colores> buscarTodas();
}
