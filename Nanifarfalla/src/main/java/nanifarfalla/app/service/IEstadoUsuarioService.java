package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoUsuario;




public interface IEstadoUsuarioService {
//Creación de CRUD con el formato Standard
	
	void inserta(EstadoUsuario estadousuario);
	void actualiza(EstadoUsuario estadousuario);
	void elimina(EstadoUsuario estadousuario);
	
	
	EstadoUsuario get(int estadoUsuarioId);
	List<EstadoUsuario> list();	
	boolean add(EstadoUsuario estadousuario);
	boolean update(EstadoUsuario estadousuario);
	boolean delete(EstadoUsuario estadousuario);
		
	//Siempre agregar la paginación
	Page<EstadoUsuario> buscarTodas(Pageable page);
	List<EstadoUsuario> buscarTodas();
}