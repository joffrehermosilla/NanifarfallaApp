package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.TipoInsumo;
import nanifarfalla.app.repository.TipoInsumoRepository;
import nanifarfalla.app.service.ITipoInsumoService;

@Service
public class TipoInsumoServiceJPA implements ITipoInsumoService{

	@Autowired
	TipoInsumoRepository tipoInsumoRepository;
	
	@Override
	public void inserta(TipoInsumo tipoInsumo) {
		tipoInsumoRepository.save(tipoInsumo);
		
	}

	@Override
	public void actualiza(TipoInsumo tipoInsumo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(TipoInsumo tipoInsumo) {
		tipoInsumoRepository.delete(tipoInsumo);
		
	}

	@Override
	public TipoInsumo get(int tipoInsumoId) {
		return tipoInsumoRepository.getOne(tipoInsumoId);
	}

	@Override
	public List<TipoInsumo> list() {
		return tipoInsumoRepository.findAll();
	}

	@Override
	public boolean add(TipoInsumo tipoInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TipoInsumo tipoInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TipoInsumo tipoInsumo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<TipoInsumo> buscarTodas(Pageable page) {
		return tipoInsumoRepository.findAll(page);
	}

	@Override
	public List<TipoInsumo> buscarTodas() {
		return tipoInsumoRepository.findAll();
	}

}
