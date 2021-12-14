package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Pais;


public interface IPaisService {
	List<Pais> buscarTodas();
	
	public Pais save(Pais pais);

	public void delete(Integer id);
}
