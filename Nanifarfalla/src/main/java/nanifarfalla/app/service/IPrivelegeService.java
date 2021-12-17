package nanifarfalla.app.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Privilege;





public interface IPrivelegeService {

	//Creación de CRUD con el formato Standard
	
		void inserta(Privilege privelege);
		void actualiza(Privilege privelege);
		void elimina(Privilege privelege);
		
		
		Privilege get(int privelegeId);
		List<Privilege> list();	
		boolean add(Privilege privelege);
		boolean update(Privilege privelege);
		boolean delete(Privilege privelege);
			
		//Siempre agregar la paginación
		Page<Privilege> buscarTodas(Pageable page);
		List<Privilege> buscarTodas();
	
	
}
