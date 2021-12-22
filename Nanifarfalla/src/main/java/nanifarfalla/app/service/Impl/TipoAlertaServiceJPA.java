package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.TipoAlerta;
import nanifarfalla.app.repository.TipoAlertaRepository;
import nanifarfalla.app.service.ITipoAlertaService;

@Service
public class TipoAlertaServiceJPA implements ITipoAlertaService {
	
	@Autowired
	private TipoAlertaRepository tipoAlertaRepository;

	@Override
	public void inserta(TipoAlerta tipoalerta) {
		tipoAlertaRepository.save(tipoalerta);
		
	}

	@Override
	public TipoAlerta get(int tipoAlertaId) {
		return tipoAlertaRepository.getOne(tipoAlertaId);
	}

	@Override
	public List<TipoAlerta> list() {
		return tipoAlertaRepository.findAll();
	}

	@Override
	public boolean guardar(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TipoAlerta> buscarTodas() {
		return tipoAlertaRepository.findAll();
	}

	@Override
	public Page<TipoAlerta> buscarTodas(Pageable page) {
		return tipoAlertaRepository.findAll(page);
	}



}
