package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.TipoUsuario;

public interface ITipoUsuarioService {

	void inserta(TipoUsuario tipoUsuario);
	
	void actualiza(TipoUsuario tipoUsuario);
	
	void elimina(TipoUsuario tipoUsuario);
	
	void eliminar (int idTipoUsuario);

	Optional<TipoUsuario> buscarporId(int id);	
		
	TipoUsuario get(int tipoUsuarioId);
	
	List<TipoUsuario> list();	
	
	boolean add(TipoUsuario tipoUsuario);
	
	boolean update(TipoUsuario tipoUsuario);
	
	boolean delete(TipoUsuario tipoUsuario);
		
	Page<TipoUsuario> buscarTodas(Pageable page);
	
	List<TipoUsuario> buscarTodas();
}
