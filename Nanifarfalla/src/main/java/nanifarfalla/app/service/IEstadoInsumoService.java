package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoInsumo;

public interface IEstadoInsumoService {

	void inserta(EstadoInsumo estadoInsumo);
	void actualiza(EstadoInsumo estadoInsumo);
	void elimina(EstadoInsumo estadoInsumo);
	
	EstadoInsumo get(int estadoInsumoId);
	List<EstadoInsumo> list();	
	boolean add(EstadoInsumo estadoInsumo);
	boolean update(EstadoInsumo estadoInsumo);
	boolean delete(EstadoInsumo estadoInsumo);
		
	Page<EstadoInsumo> buscarTodas(Pageable page);
	List<EstadoInsumo> buscarTodas();
}
