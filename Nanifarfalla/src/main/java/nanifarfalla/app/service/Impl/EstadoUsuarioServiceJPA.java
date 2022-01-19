package nanifarfalla.app.service.Impl;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.controller.EstadoUsuarioController;
import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.repository.EstadoUsuarioRepository;
import nanifarfalla.app.service.IEstadoUsuarioService;

@Service
public class EstadoUsuarioServiceJPA implements IEstadoUsuarioService {
	private final static Logger LOGGER = LoggerFactory.getLogger(EstadoUsuarioServiceJPA.class);
	@Autowired
	EstadoUsuarioRepository estadousuariorepository;

	@Override
	public void inserta(EstadoUsuario estadousuario) {
		// TODO Auto-generated method stub
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		estadousuario.setVersion(timestamp);

		estadousuariorepository.save(estadousuario);

	}

	@Override
	public void actualiza(EstadoUsuario estadousuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(EstadoUsuario estadousuario) {
		// TODO Auto-generated method stub

		estadousuariorepository.delete(estadousuario);

	}

	@Override
	public EstadoUsuario get(int estadoUsuarioId) {
		// TODO Auto-generated method stub
		return estadousuariorepository.getOne(estadoUsuarioId);
	}

	@Override
	public List<EstadoUsuario> list() {
		// TODO Auto-generated method stub
		return estadousuariorepository.findAll();
	}

	@Override
	public boolean add(EstadoUsuario estadousuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoUsuario estadousuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoUsuario estadousuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<EstadoUsuario> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return estadousuariorepository.findAll(page);
	}

	@Override
	public List<EstadoUsuario> buscarTodas() {
		// TODO Auto-generated method stub
		return estadousuariorepository.findAll();
	}

	@Override
	public Optional<EstadoUsuario> buscarporId(int id) {
		// TODO Auto-generated method stub
		return estadousuariorepository.findById(id);
	}

	@Override
	public void eliminar(int idEstadoUsuario) {
		estadousuariorepository.deleteById(idEstadoUsuario);
	}

}
