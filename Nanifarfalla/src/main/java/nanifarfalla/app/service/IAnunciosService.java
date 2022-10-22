package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.Anuncio;

public interface IAnunciosService {

	List<Anuncio> buscarTodas();

	void guardar(Anuncio anuncio);

	// Anuncio buscarporId(int idAnuncio);

	void inserta(Anuncio anuncio, MultipartFile multiPart, HttpServletRequest request);

	void actualiza(Anuncio anuncio);

	void elimina(Anuncio anuncio);

	void eliminar(int idAnuncio);

	Optional<Anuncio> buscarporId(int id);

	Anuncio get(int anunciogetId);

	List<Anuncio> list();

	boolean add(Anuncio anuncio);

	boolean update(Anuncio anuncio);

	boolean delete(Anuncio anuncio);

	Page<Anuncio> buscarTodas(Pageable page);

}
