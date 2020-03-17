package nanifarfalla.app.service;

import java.util.List;



import nanifarfalla.app.model.Anuncio;

public interface IAnunciosService {
	void inserta(Anuncio anuncio);

	List<Anuncio> buscarTodas();

	void guardar(Anuncio anuncio);

	Anuncio buscarporId(int idAnuncio);
}
