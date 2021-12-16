package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Role;




public interface IRoleService {

	//Creación de CRUD con el formato Standard
	
		void inserta(Role role);
		void actualiza(Role role);
		void elimina(Role role);
		
		
		Role get(int roleId);
		List<Role> list();	
		boolean add(Role role);
		boolean update(Role role);
		boolean delete(Role role);
			
		//Siempre agregar la paginación
		Page<Role> buscarTodas(Pageable page);
		List<Role> buscarTodas();
	
	
}
