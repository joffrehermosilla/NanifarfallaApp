package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.PresentacionInsumo;
import nanifarfalla.app.repository.PresentacionInsumoRepository;
import nanifarfalla.app.service.IPresentacionInsumoService;

@Service
public class PresentacionInsumoServiceJPA implements IPresentacionInsumoService{

	@Autowired
	PresentacionInsumoRepository presentacionInsumoRepository;
	
	@Override
	public void inserta(PresentacionInsumo presentacionInsumo) {
		presentacionInsumoRepository.save(presentacionInsumo);
		
	}

	@Override
	public void actualiza(PresentacionInsumo presentacionInsumo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(PresentacionInsumo presentacionInsumo) {
		presentacionInsumoRepository.delete(presentacionInsumo);
		
	}

	@Override
	public PresentacionInsumo get(int presentacionInsumoId) {
		return presentacionInsumoRepository.getOne(presentacionInsumoId);
	}

	@Override
	public List<PresentacionInsumo> list() {
		return presentacionInsumoRepository.findAll();
	}

	@Override
	public boolean add(PresentacionInsumo presentacionInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PresentacionInsumo presentacionInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PresentacionInsumo presentacionInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<PresentacionInsumo> buscarTodas(Pageable page) {
		return presentacionInsumoRepository.findAll(page);
	}

	@Override
	public List<PresentacionInsumo> buscarTodas() {
		return presentacionInsumoRepository.findAll();
	}

}
