package nanifarfalla.app.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoContrato;


public interface IEstadoContratoService {

	//Creación de CRUD con el formato Standard
	
		void inserta(EstadoContrato estadocontrato);
		void actualiza(EstadoContrato estadocontrato);
		void elimina(EstadoContrato estadocontrato);
		
		
		EstadoContrato get(int estadocontratoId);
		List<EstadoContrato> list();	
		boolean add(EstadoContrato estadocontrato);
		boolean update(EstadoContrato estadocontrato);
		boolean delete(EstadoContrato estadocontrato);
			
		//Siempre agregar la paginación
		Page<EstadoContrato> buscarTodas(Pageable page);
		List<EstadoContrato> buscarTodas();
	
	
	
}
