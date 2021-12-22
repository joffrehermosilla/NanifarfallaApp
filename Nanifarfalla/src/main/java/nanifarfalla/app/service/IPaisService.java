package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Pais;


public interface IPaisService {
	void inserta(Pais pais);
	void actualiza(Pais pais);
	void elimina(Pais pais);
		
	Pais get(int paisId);
	List<Pais> list();	
	boolean add(Pais pais);
	boolean update(Pais pais);
	boolean delete(Pais pais);
		
	Page<Pais> buscarTodas(Pageable page);
	List<Pais> buscarTodas();
}
