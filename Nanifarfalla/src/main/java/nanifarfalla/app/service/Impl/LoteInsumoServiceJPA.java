package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.LoteInsumo;
import nanifarfalla.app.repository.LoteInsumoRepository;
import nanifarfalla.app.service.ILoteInsumoService;

@Service
public class LoteInsumoServiceJPA implements ILoteInsumoService{

	@Autowired
	LoteInsumoRepository loteInsumoRepository;
	
	@Override
	public void inserta(LoteInsumo loteInsumo) {
		loteInsumoRepository.save(loteInsumo);
		
	}

	@Override
	public void actualiza(LoteInsumo loteInsumo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(LoteInsumo loteInsumo) {
		loteInsumoRepository.delete(loteInsumo);
		
	}

	@Override
	public LoteInsumo get(int loteInsumoId) {
		return loteInsumoRepository.getOne(loteInsumoId);
	}

	@Override
	public List<LoteInsumo> list() {
		return loteInsumoRepository.findAll();
	}

	@Override
	public boolean add(LoteInsumo loteInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LoteInsumo loteInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LoteInsumo loteInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<LoteInsumo> buscarTodas(Pageable page) {
		return loteInsumoRepository.findAll(page);
	}

	@Override
	public List<LoteInsumo> buscarTodas() {
		return loteInsumoRepository.findAll();
	}

}
