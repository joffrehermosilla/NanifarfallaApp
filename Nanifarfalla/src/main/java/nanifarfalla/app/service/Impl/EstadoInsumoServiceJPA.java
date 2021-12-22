package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.EstadoInsumo;
import nanifarfalla.app.repository.EstadoInsumoRepository;
import nanifarfalla.app.service.IEstadoInsumoService;

@Service
public class EstadoInsumoServiceJPA implements IEstadoInsumoService{

	@Autowired
	EstadoInsumoRepository estadoInsumoRepository;
	
	@Override
	public void inserta(EstadoInsumo estadoInsumo) {
		estadoInsumoRepository.save(estadoInsumo);
		
	}

	@Override
	public void actualiza(EstadoInsumo estadoInsumo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(EstadoInsumo estadoInsumo) {
		estadoInsumoRepository.delete(estadoInsumo);
		
	}

	@Override
	public EstadoInsumo get(int estadoInsumoId) {
		return estadoInsumoRepository.getOne(estadoInsumoId);
	}

	@Override
	public List<EstadoInsumo> list() {
		return estadoInsumoRepository.findAll();
	}

	@Override
	public boolean add(EstadoInsumo estadoInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoInsumo estadoInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoInsumo estadoInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<EstadoInsumo> buscarTodas(Pageable page) {
		return estadoInsumoRepository.findAll(page);
	}

	@Override
	public List<EstadoInsumo> buscarTodas() {
		return estadoInsumoRepository.findAll();
	}

}
