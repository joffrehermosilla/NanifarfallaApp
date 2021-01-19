package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Ciudad;
import nanifarfalla.app.repository.CiudadRepository;
import nanifarfalla.app.service.ICiudadService;

@Service
public class CiudadServicioJPA implements ICiudadService {

	@Autowired
	CiudadRepository ciudadRepository;

	@Override
	public List<Ciudad> buscarTodas() {
		// TODO Auto-generated method stub
		return ciudadRepository.findAll();
	}

	@Override
	public List<Ciudad> findByProvinciaIdParamsNative(int idProvincia) {
		// TODO Auto-generated method stub
		return ciudadRepository.findByProvinciaIdParamsNative(idProvincia);
	}

	@Override
	public List<Ciudad> findByFkcodigo_provincia(int codigo_provincia) {
		// TODO Auto-generated method stub
		return ciudadRepository.findByFkcodigo_provincia(codigo_provincia);
	}

	@Override
	public List<Ciudad> findByState(int id) {
		// TODO Auto-generated method stub
		return ciudadRepository.findByState(id);
	}

	@Override
	public List<Ciudad> BuscaProvinciaporClase(int id) {
		// TODO Auto-generated method stub
		return ciudadRepository.BuscaProvinciaporClase(id);
	}

	@Override
	public List<Ciudad> BuscarProvinciaClaseconParam(int codig_provincia) {
		// TODO Auto-generated method stub
		return ciudadRepository.BuscarProvinciaClaseconParam(codig_provincia);
	}

}
