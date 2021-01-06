package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Ciudad;


public interface ICiudadService {
	List<Ciudad> buscarTodas();
	
	List<Ciudad> findByProvincia(int idProvincia);
}
