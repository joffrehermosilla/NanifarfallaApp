package nanifarfalla.app.service.Impl;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.EstadoCatalogo;
import nanifarfalla.app.repository.EstadoCatalogoRepository;
import nanifarfalla.app.service.IEstadoCatalogo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Service
public class EstadoCatalogoServiceJPA implements IEstadoCatalogo {
	
	
	@Autowired
	EstadoCatalogoRepository estadocatalogorepository;

	@Override
	public void inserta(EstadoCatalogo estadocatalogo) {
		// TODO Auto-generated method stub
		estadocatalogorepository.save(estadocatalogo);
	}

	@Override
	public void actualiza(EstadoCatalogo estadocatalogo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(EstadoCatalogo estadocatalogo) {
		// TODO Auto-generated method stub
		estadocatalogorepository.delete(estadocatalogo);
		
	}

	@Override
	public EstadoCatalogo get(int estadoCatalogoId) {
		// TODO Auto-generated method stub
		return estadocatalogorepository.getOne(estadoCatalogoId);
	}

	@Override
	public List<EstadoCatalogo> list() {
		// TODO Auto-generated method stub
		return estadocatalogorepository.findAll();
	}

	@Override
	public boolean add(EstadoCatalogo estadocatalogo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoCatalogo estadocatalogo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoCatalogo estadocatalogo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<EstadoCatalogo> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return estadocatalogorepository.findAll(page);
	}

	@Override
	public List<EstadoCatalogo> buscarTodas() {
		// TODO Auto-generated method stub
		return estadocatalogorepository.findAll();
	}

}
