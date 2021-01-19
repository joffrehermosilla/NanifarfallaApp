package nanifarfalla.app.service;

import java.util.List;



import nanifarfalla.app.model.Ciudad;


public interface ICiudadService {
	List<Ciudad> buscarTodas();
	

	
	List<Ciudad> findByProvinciaIdParamsNative( int idProvincia);
	
	List<Ciudad> findByFkcodigo_provincia(int codigo_provincia);
	
	 List<Ciudad> findByState( int id);
	 
	 List<Ciudad> BuscaProvinciaporClase(int id);
	 
	 List<Ciudad> BuscarProvinciaClaseconParam( int codig_provincia);
	
}
