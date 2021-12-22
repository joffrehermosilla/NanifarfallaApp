package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.TipoAlerta;

public interface ITipoAlertaService {
	
	void inserta(TipoAlerta tipoalerta);

	TipoAlerta get(int tipoAlertaId);
	List<TipoAlerta> list();
	boolean guardar(TipoAlerta tipoalerta);
	
	List<TipoAlerta> buscarTodas();
	Page<TipoAlerta> buscarTodas(Pageable page);	
}
