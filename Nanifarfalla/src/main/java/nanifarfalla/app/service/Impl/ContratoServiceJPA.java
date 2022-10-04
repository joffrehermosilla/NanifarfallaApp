package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Contrato;
import nanifarfalla.app.repository.ContratoRepository;
import nanifarfalla.app.service.IContratoService;

@Service
public class ContratoServiceJPA implements IContratoService {

	@Autowired
	ContratoRepository contratoRepository;

	@Override
	public void guardar(Contrato contrato) {

		contratoRepository.save(contrato);

	}

	@Override
	public List<Contrato> buscartodos() {

		return contratoRepository.findAll();
	}

	@Override
	public int lastcode() {
		// TODO Auto-generated method stub
		return contratoRepository.lastcode();
	}

	@Override
	public void inserta(Contrato contrato) {
		// TODO Auto-generated method stub
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		contrato.setVersion(timestamp);
		contratoRepository.save(contrato);
	}

	@Override
	public void actualiza(Contrato contrato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(Contrato contrato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int idContrato) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Contrato> buscarporId(int id) {
		// TODO Auto-generated method stub
		return contratoRepository.findById(id);
	}

	@Override
	public Contrato get(int contratoId) {
		// TODO Auto-generated method stub
		return contratoRepository.getOne(contratoId);
	}

	@Override
	public List<Contrato> list() {
		// TODO Auto-generated method stub
		return contratoRepository.findAll();
	}

	@Override
	public boolean add(Contrato contrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Contrato contrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Contrato contrato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Contrato> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return contratoRepository.findAll(page);
	}

	@Override
	public List<Contrato> buscarTodas() {
		// TODO Auto-generated method stub
		return contratoRepository.findAll();
	}

}
