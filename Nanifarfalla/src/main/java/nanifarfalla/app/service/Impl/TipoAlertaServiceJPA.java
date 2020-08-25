package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<TipoAlerta> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoAlerta buscarporId(int idTipoAlerta) {
		// TODO Auto-generated method stub
		return null;
	}

}
