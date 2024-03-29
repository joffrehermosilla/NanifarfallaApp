package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.ElaboracionProducto;

import nanifarfalla.app.repository.ElaboracionProductoRepository;
import nanifarfalla.app.service.IElaboracionProductoService;

@Service
public class ElaboracionProductoServiceJPA implements IElaboracionProductoService {

	@Autowired
	ElaboracionProductoRepository elaboracionProductoRepository;

	@Override
	public void inserta(ElaboracionProducto elaboracionProducto) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		elaboracionProducto.setVersion(timestamp);

		elaboracionProductoRepository.save(elaboracionProducto);

	}

	@Override
	public void actualiza(ElaboracionProducto elaboracionProducto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(ElaboracionProducto elaboracionProducto) {
		elaboracionProductoRepository.delete(elaboracionProducto);

	}

	@Override
	public ElaboracionProducto get(int elaboracionProductoId) {
		return elaboracionProductoRepository.getOne(elaboracionProductoId);
	}

	@Override
	public List<ElaboracionProducto> list() {
		return elaboracionProductoRepository.findAll();
	}

	@Override
	public boolean add(ElaboracionProducto elaboracionProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ElaboracionProducto elaboracionProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ElaboracionProducto elaboracionProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<ElaboracionProducto> buscarTodas(Pageable page) {
		return elaboracionProductoRepository.findAll(page);
	}

	@Override
	public List<ElaboracionProducto> buscarTodas() {
		return elaboracionProductoRepository.findAll();
	}

	@Override
	public void eliminar(int idElaboracionProducto) {
		// TODO Auto-generated method stub
		elaboracionProductoRepository.deleteById(idElaboracionProducto);
	}

	@Override
	public Optional<ElaboracionProducto> buscarporId(int id) {
		// TODO Auto-generated method stub
		return elaboracionProductoRepository.findById(id);
	}

}
