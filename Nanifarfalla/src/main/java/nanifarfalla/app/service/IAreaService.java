package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Area;




public interface IAreaService {

	//Creación de CRUD con el formato Standard
	
		void inserta(Area area);
		void actualiza(Area area);
		void elimina(Area area);
		
		
		Area get(int areaId);
		List<Area> list();	
		boolean add(Area area);
		boolean update(Area area);
		boolean delete(Area area);
			
		//Siempre agregar la paginación
		Page<Area> buscarTodas(Pageable page);
		List<Area> buscarTodas();
	
	
}
