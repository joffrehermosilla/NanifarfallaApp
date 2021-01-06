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
	public List<Ciudad> findByProvincia(int idProvincia) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
