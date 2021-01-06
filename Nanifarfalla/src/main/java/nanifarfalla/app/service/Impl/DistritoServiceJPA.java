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
	public List<Distrito> findByCiudad(int idCiudad) {
		return null;
		// TODO Auto-generated method stub
		//return distritorepository.findByCiudad(idCiudad);
	}

}
