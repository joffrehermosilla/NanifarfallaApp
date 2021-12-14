package nanifarfalla.app.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.TipoImpuesto;


public interface ITipoImpuesto {

	void inserta(TipoImpuesto tipoimpuesto);
	void actualiza(TipoImpuesto tipoimpuesto);
	void elimina(TipoImpuesto tipoimpuesto);
	
	
	TipoImpuesto get(int TipoImpuestoId);
	List<TipoImpuesto> list();	
	boolean add(TipoImpuesto tipoimpuesto);
	boolean update(TipoImpuesto tipoimpuesto);
	boolean delete(TipoImpuesto tipoimpuesto);
		
	//Siempre agregar la paginación
	Page<TipoImpuesto> buscarTodas(Pageable page);
	List<TipoImpuesto> buscarTodas();
	
	
}
