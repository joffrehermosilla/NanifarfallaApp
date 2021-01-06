package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Distrito;


public interface IDistritoService {
	List<Distrito> buscarTodas();
	
	List<Distrito> findByCiudad(int idCiudad);
}
