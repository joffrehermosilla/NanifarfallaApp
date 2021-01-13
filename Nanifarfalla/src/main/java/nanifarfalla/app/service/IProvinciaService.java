package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Provincia;

public interface IProvinciaService {
	List<Provincia> buscarTodas();
	
	List<Provincia> findByPaisIdParamsNative(int idPais);
}
