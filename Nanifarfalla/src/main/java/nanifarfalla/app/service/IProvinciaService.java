package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import nanifarfalla.app.model.Provincia;

public interface IProvinciaService {
	List<Provincia> buscarTodas();

	List<Provincia> findByPaisIdParamsNative(int idPais);

	List<Provincia> findByFkcodigo_pais(int codigo_pais);

	List<Provincia> findByCountry(int id);

	List<Provincia> BuscaPaisporClase(int id);
	
	List<Provincia> BuscarPaisClaseconParam(int codig_pais);
	
	

}
