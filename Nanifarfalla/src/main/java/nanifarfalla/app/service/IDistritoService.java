package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Distrito;

public interface IDistritoService {
	List<Distrito> buscarTodas();

	List<Distrito> findByCiudadIdParamsNative(int idCiudad);

	List<Distrito> findByFkcodigo_ciudad(int codigo_ciudad);

	List<Distrito> findByCity(int id);

	List<Distrito> BuscaCiudadporClase(int id);

	List<Distrito> BuscarCiudadClaseconParam(int codigo_ciudad);

}
