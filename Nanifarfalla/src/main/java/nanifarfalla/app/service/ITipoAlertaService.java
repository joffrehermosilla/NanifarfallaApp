package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.TipoAlerta;

public interface ITipoAlertaService {
	void inserta(TipoAlerta tipoalerta);

	List<TipoAlerta> buscarTodas();

	void guardar(TipoAlerta tipoalerta);

	TipoAlerta buscarporId(int idTipoAlerta);
}
