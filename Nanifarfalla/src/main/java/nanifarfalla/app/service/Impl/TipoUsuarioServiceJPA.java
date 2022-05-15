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

import nanifarfalla.app.model.TipoUsuario;
import nanifarfalla.app.repository.TipoUsuarioRepository;
import nanifarfalla.app.service.ITipoUsuarioService;


@Service
public class TipoUsuarioServiceJPA implements ITipoUsuarioService{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TipoUsuarioServiceJPA.class);

	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public void inserta(TipoUsuario tipoUsuario) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		tipoUsuario.setVersion(timestamp);
		
		tipoUsuarioRepository.save(tipoUsuario);
		
	}

	@Override
	public void actualiza(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void elimina(TipoUsuario tipoUsuario) {
		tipoUsuarioRepository.delete(tipoUsuario);
	}

	@Override
	public TipoUsuario get(int tipoUsuarioId) {
		return tipoUsuarioRepository.getOne(tipoUsuarioId);
	}

	@Override
	public List<TipoUsuario> list() {
		return tipoUsuarioRepository.findAll();
	}

	@Override
	public boolean add(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<TipoUsuario> buscarTodas(Pageable page) {
		return tipoUsuarioRepository.findAll(page);
	}

	@Override
	public List<TipoUsuario> buscarTodas() {
		return tipoUsuarioRepository.findAll();
	}

	@Override
	public void eliminar(int idTipoUsuario) {
		tipoUsuarioRepository.deleteById(idTipoUsuario);			
	}

	@Override
	public Optional<TipoUsuario> buscarporId(int id) {
		return tipoUsuarioRepository.findById(id);
	}
	

}
