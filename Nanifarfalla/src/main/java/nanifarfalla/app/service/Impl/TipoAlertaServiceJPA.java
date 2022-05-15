package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		tipoalerta.setVersion(timestamp);
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
	public List<TipoAlerta> buscarTodas() {
		return tipoAlertaRepository.findAll();
	}

	@Override
	public Page<TipoAlerta> buscarTodas(Pageable page) {
		return tipoAlertaRepository.findAll(page);
	}

	@Override
	public void eliminar(int idTipoAlerta) {
		// TODO Auto-generated method stub
		tipoAlertaRepository.deleteById(idTipoAlerta);
	}

	@Override
	public Optional<TipoAlerta> buscarporId(int id) {
		// TODO Auto-generated method stub
		return tipoAlertaRepository.findById(id);
	}

	@Override
	public boolean guardar(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actualiza(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TipoAlerta tipoalerta) {
		// TODO Auto-generated method stub
		return false;
	}

}
