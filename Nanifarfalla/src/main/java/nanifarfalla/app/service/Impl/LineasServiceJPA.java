package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Linea;
import nanifarfalla.app.repository.LineaRepository;
import nanifarfalla.app.service.ILineasService;

@Service
public class LineasServiceJPA implements ILineasService {

	@Autowired
	private LineaRepository linearepository;
	
	@Override
	public List<Linea> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Linea buscarPorId(int idLinea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserta(Linea linea) {
	
		linearepository.save(linea);
	}

}