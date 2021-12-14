package nanifarfalla.app.service.Impl;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.repository.EstadoUsuarioRepository;
import nanifarfalla.app.service.IEstadoUsuario;



@Service
public class EstadoUsuarioServiceJPA implements IEstadoUsuario{
	@Autowired
	EstadoUsuarioRepository estadousuariorepository;
	
	
	@Override
	public void inserta(EstadoUsuario estadousuario) {
		// TODO Auto-generated method stub
		
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
	
	
	
}
