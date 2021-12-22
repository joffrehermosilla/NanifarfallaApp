package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Colores;
import nanifarfalla.app.repository.ColoresRepository;
import nanifarfalla.app.service.IColoresService;

@Service
public class ColoresServiceJPA implements IColoresService{

	@Autowired
	ColoresRepository coloresRepository;
	
	@Override
	public void inserta(Colores colores) {
		coloresRepository.save(colores);
		
	}

	@Override
	public void actualiza(Colores colores) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(Colores colores) {
		coloresRepository.delete(colores);
		
	}

	@Override
	public Colores get(int coloresId) {
		return coloresRepository.getOne(coloresId);
	}

	@Override
	public List<Colores> list() {
		return coloresRepository.findAll();
	}

	@Override
	public boolean add(Colores colores) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Colores colores) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Colores colores) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Colores> buscarTodas(Pageable page) {
		return coloresRepository.findAll(page);
	}

	@Override
	public List<Colores> buscarTodas() {
		return coloresRepository.findAll();
	}

}
