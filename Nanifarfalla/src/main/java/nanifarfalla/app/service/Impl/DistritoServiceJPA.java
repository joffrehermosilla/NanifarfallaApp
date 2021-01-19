package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Distrito;
import nanifarfalla.app.repository.DistritoRepository;
import nanifarfalla.app.service.IDistritoService;

@Service
public class DistritoServiceJPA implements IDistritoService {

	@Autowired
	DistritoRepository distritorepository;

	@Override
	public List<Distrito> buscarTodas() {
		// TODO Auto-generated method stub
		return distritorepository.findAll();
	}

	@Override
	public List<Distrito> findByCiudadIdParamsNative(int idCiudad) {
		// TODO Auto-generated method stub
		return distritorepository.findByCiudadIdParamsNative(idCiudad);
	}

	@Override
	public List<Distrito> findByFkcodigo_ciudad(int codigo_ciudad) {
		// TODO Auto-generated method stub
		return distritorepository.findByFkcodigo_ciudad(codigo_ciudad);
	}

	@Override
	public List<Distrito> findByCity(int id) {
		// TODO Auto-generated method stub
		return distritorepository.findByCity(id);
	}

	@Override
	public List<Distrito> BuscaCiudadporClase(int id) {
		// TODO Auto-generated method stub
		return distritorepository.BuscaCiudadporClase(id);
	}

	@Override
	public List<Distrito> BuscarCiudadClaseconParam(int codigo_ciudad) {
		// TODO Auto-generated method stub
		return distritorepository.BuscarCiudadClaseconParam(codigo_ciudad);
	}

}
