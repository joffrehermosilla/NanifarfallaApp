package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Alerta;
import nanifarfalla.app.repository.AlertaRepository;
import nanifarfalla.app.service.IAlertaService;

@Service
public class AlertaServiceJPA implements IAlertaService {

	private final static Logger LOGGER = LoggerFactory.getLogger(AlertaServiceJPA.class);

	@Autowired
	private AlertaRepository alertaRepository;

	@Override
	public void inserta(Alerta alerta) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		alerta.setVersion(timestamp);
		alertaRepository.save(alerta);

	}

	@Override
	public List<Alerta> buscarTodas() {
		// TODO Auto-generated method stub
		return alertaRepository.findAll();
	}

	@Override
	public void guardar(Alerta alerta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualiza(Alerta alerta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(Alerta alerta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int idAlerta) {
		// TODO Auto-generated method stub

		alertaRepository.deleteById(idAlerta);

	}

	@Override
	public Optional<Alerta> buscarporId(int id) {
		// TODO Auto-generated method stub
		return alertaRepository.findById(id);
	}

	@Override
	public Alerta get(int alertagetId) {
		// TODO Auto-generated method stub
		return alertaRepository.getOne(alertagetId);
	}

	@Override
	public List<Alerta> list() {
		// TODO Auto-generated method stub
		return alertaRepository.findAll();
	}

	@Override
	public boolean add(Alerta alerta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Alerta alerta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Alerta alerta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Alerta> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return alertaRepository.findAll(page);
	}

}
