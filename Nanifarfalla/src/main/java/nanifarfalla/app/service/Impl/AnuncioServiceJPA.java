package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.Anuncio;
import nanifarfalla.app.repository.AnuncioRepository;
import nanifarfalla.app.service.IAnunciosService;
import nanifarfalla.app.util.Utileria;

@Service
public class AnuncioServiceJPA implements IAnunciosService {

	private final static Logger LOGGER = LoggerFactory.getLogger(AnuncioServiceJPA.class);

	@Autowired
	AnuncioRepository anuncioRepository;

	@Override
	public List<Anuncio> buscarTodas() {
		// TODO Auto-generated method stub
		return anuncioRepository.findAll();
	}

	@Override
	public void guardar(Anuncio anuncio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserta(Anuncio anuncio, MultipartFile multiPart, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		anuncio.setVersion(timestamp);

		if (!multiPart.isEmpty()) {
			String ruta = "/resources/images/anuncio/";
			String rutax = "/resources/images/anuncio/";

			// System.out.println("ruta: " + ruta);
			// LOGGER.info("ruta: " + ruta);
			// System.out.println("rutax: " + rutax);
			LOGGER.info("rutax: " + rutax);
			String nombreImagen = Utileria.guardarImagenPlus(multiPart, request, rutax);
			anuncio.setRuta_imagen(nombreImagen);
	

		}
		anuncioRepository.save(anuncio);
	}

	@Override
	public void actualiza(Anuncio anuncio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(Anuncio anuncio) {
		// TODO Auto-generated method stub
		anuncioRepository.delete(anuncio);
	}

	@Override
	public void eliminar(int idAnuncio) {
		// TODO Auto-generated method stub

		anuncioRepository.deleteById(idAnuncio);

	}

	@Override
	public Optional<Anuncio> buscarporId(int id) {
		// TODO Auto-generated method stub
		return anuncioRepository.findById(id);
	}

	@Override
	public Anuncio get(int anunciogetId) {
		// TODO Auto-generated method stub
		return anuncioRepository.getOne(anunciogetId);
	}

	@Override
	public List<Anuncio> list() {
		// TODO Auto-generated method stub
		return anuncioRepository.findAll();
	}

	@Override
	public boolean add(Anuncio anuncio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Anuncio anuncio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Anuncio anuncio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Anuncio> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return anuncioRepository.findAll(page);
	}

}
