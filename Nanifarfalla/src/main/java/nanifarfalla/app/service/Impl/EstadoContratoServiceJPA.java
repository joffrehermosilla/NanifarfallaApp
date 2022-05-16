package nanifarfalla.app.service.Impl;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.EstadoContrato;
import nanifarfalla.app.repository.EstadoContratoRepository;
import nanifarfalla.app.service.IEstadoContratoService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class EstadoContratoServiceJPA implements IEstadoContratoService {

	@Autowired
	EstadoContratoRepository estadocontratorepository;

	@Override
	public void inserta(EstadoContrato estadocontrato) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		estadocontrato.setVersion(timestamp);
		estadocontratorepository.save(estadocontrato);
	}

	@Override
	public EstadoContrato get(int estadocontratoId) {
		// TODO Auto-generated method stub
		return estadocontratorepository.getOne(estadocontratoId);
	}

	@Override
	public List<EstadoContrato> list() {
		// TODO Auto-generated method stub
		return estadocontratorepository.findAll();
	}

	@Override
	public Page<EstadoContrato> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return estadocontratorepository.findAll(page);
	}

	@Override
	public List<EstadoContrato> buscarTodas() {
		// TODO Auto-generated method stub
		return estadocontratorepository.findAll();
	}

	@Override
	public Optional<EstadoContrato> buscarporId(int id) {
		// TODO Auto-generated method stub
		return estadocontratorepository.findById(id);
	}

	@Override
	public void eliminar(int idTipoContrato) {
		// TODO Auto-generated method stub
		estadocontratorepository.deleteById(idTipoContrato);
	}

	@Override
	public void elimina(EstadoContrato estadocontrato) {
		// TODO Auto-generated method stub

		estadocontratorepository.delete(estadocontrato);

	}

	@Override
	public boolean add(EstadoContrato estadocontrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoContrato estadocontrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoContrato estadocontrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(EstadoContrato estadocontrato) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
