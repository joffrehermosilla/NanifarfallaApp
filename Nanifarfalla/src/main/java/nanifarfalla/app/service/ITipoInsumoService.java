package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.TipoInsumo;

public interface ITipoInsumoService {

	void inserta(TipoInsumo tipoInsumo);
	void actualiza(TipoInsumo tipoInsumo);
	void elimina(TipoInsumo tipoInsumo);
		
	TipoInsumo get(int tipoInsumoId);
	List<TipoInsumo> list();	
	boolean add(TipoInsumo tipoInsumo);
	boolean update(TipoInsumo tipoInsumo);
	boolean delete(TipoInsumo tipoInsumo);
		
	Page<TipoInsumo> buscarTodas(Pageable page);
	List<TipoInsumo> buscarTodas();
}
