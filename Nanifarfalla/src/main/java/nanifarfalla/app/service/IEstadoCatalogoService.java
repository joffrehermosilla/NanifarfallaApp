package nanifarfalla.app.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoCatalogo;






public interface IEstadoCatalogoService {

	void inserta(EstadoCatalogo estadocatalogo);
	void actualiza(EstadoCatalogo estadocatalogo);
	void elimina(EstadoCatalogo estadocatalogo);
	
	
	EstadoCatalogo get(int estadoCatalogoId);
	List<EstadoCatalogo> list();	
	boolean add(EstadoCatalogo estadocatalogo);
	boolean update(EstadoCatalogo estadocatalogo);
	boolean delete(EstadoCatalogo estadocatalogo);
		
	//Siempre agregar la paginación
	Page<EstadoCatalogo> buscarTodas(Pageable page);
	List<EstadoCatalogo> buscarTodas();
	
	
	
}
