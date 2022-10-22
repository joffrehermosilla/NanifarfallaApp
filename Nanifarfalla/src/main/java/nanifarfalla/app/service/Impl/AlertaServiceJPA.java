package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Alerta;
import nanifarfalla.app.repository.AlertaRepository;
import nanifarfalla.app.service.IAlertaService;

@Service
public class AlertaServiceJPA implements IAlertaService {
	@Autowired
	private AlertaRepository alertaRepository;

	@Override
	public void inserta(Alerta alerta) {
		alertaRepository.save(alerta);

	}

	@Override
	public List<Alerta> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Alerta alerta) {
		// TODO Auto-generated method stub

	}

	@Override
	public Alerta buscarporId(int idAlerta) {
		// TODO Auto-generated method stub
		return null;
	}

}
