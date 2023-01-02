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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.Producto;
import nanifarfalla.app.repository.LineaRepository;
import nanifarfalla.app.service.ILineasService;
import nanifarfalla.app.util.Utileria;
import nanifarfalla.app.web.dto.LineaDto;

@Service
public class LineasServiceJPA implements ILineasService {
	private final static Logger LOGGER = LoggerFactory.getLogger(LineasServiceJPA.class);
	@Autowired
	private LineaRepository linearepository;

	@Override
	public Linea buscarPorId(int idLinea) {
		// TODO Auto-generated method stub
		return linearepository.getOne(idLinea);
	}

	@Override
	public void inserta(Linea linea) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		linea.setVersion(timestamp);
		linearepository.save(linea);
	}

	@Override
	public Linea get(int id) {
		// TODO Auto-generated method stub
		return linearepository.getOne(id);
	}

	@Override
	public List<Linea> list() {
		// TODO Auto-generated method stub
		return linearepository.findAll();
	}

	@Override
	public boolean add(Linea category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Linea category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Linea category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> findProductobyLineaIdParamsNative(int idLinea) {
		// TODO Auto-generated method stub
		return linearepository.findProductobyLineaIdParamsNative(idLinea);
	}

	@Override
	public List<Linea> findBycodigo_linea(int codigo_linea) {
		// TODO Auto-generated method stub
		return linearepository.findBycodigo_linea(codigo_linea);
	}

	@Override
	public List<Linea> findByid_linea(int id) {
		// TODO Auto-generated method stub
		return linearepository.findByid_linea(id);
	}

	@Override
	public Page<Linea> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return linearepository.findAll(page);
	}

	@Override
	public List<Linea> buscarTodas() {
		// TODO Auto-generated method stub
		return linearepository.findAll();
	}

	@Override
	public void eliminar(int idLinea) {
		// TODO Auto-generated method stub

		linearepository.deleteById(idLinea);

	}

	@Override
	public Optional<Linea> buscarporId(int id) {
		// TODO Auto-generated method stub
		return linearepository.findById(id);
	}

	@Override
	public String registerLineaString(LineaDto lineaDto, int active, MultipartFile multiPart, MultipartFile multiPartx,
			HttpServletRequest request, Authentication authentication) {
		final Linea linea = new Linea();
		LOGGER.info("Usuario: " + authentication.getName());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		linea.setNombre_linea(lineaDto.getNombre_linea());
		String rutasesion = linearepository.findRutaFicheroSesion(authentication.getName());
		LOGGER.info("rutasesion: " + rutasesion);

		if (!multiPart.isEmpty()) {
			String ruta = "/resources/images/" + rutasesion + "/" + linea.getNombre_linea() + "/" + "1";

			// System.out.println("ruta: " + ruta);
			LOGGER.info("ruta primera foto: " + ruta);
			// System.out.println("rutax: " + rutax);

			String nombreImagen = Utileria.guardarImagenPlus(multiPart, request, ruta);
			linea.setFoto_linea(nombreImagen);

		}
		if (!multiPartx.isEmpty()) {
			String rutax = "/resources/images/" + rutasesion + "/" + linea.getNombre_linea() + "/" + "2";

			// System.out.println("ruta: " + ruta);
			LOGGER.info("ruta segunda foto: " + rutax);
			// System.out.println("rutax: " + rutax);

			String nombreImagenx = Utileria.guardarImagenPlus(multiPartx, request, rutax);
			linea.setFoto_ruta(nombreImagenx);

		}
		linea.setVersion(timestamp);

		LOGGER.info("contraseña encriptada");

		return null;
	}

	@Override
	public String findRutaFicheroSesion(String usernamex) {
		// TODO Auto-generated method stub
		LOGGER.info("ruta de SESION es:" + linearepository.findRutaFicheroSesion(usernamex));
		return linearepository.findRutaFicheroSesion(usernamex);
	}

	@Override
	public String registroLineaString(LineaDto lineaDto, int active, MultipartFile multiPart, MultipartFile multiPartx,
			HttpServletRequest request) {
		// TODO Auto-generated method stub

		final Linea linea = new Linea();

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		linea.setNombre_linea(lineaDto.getNombre_linea());

		if (!multiPart.isEmpty()) {
			String ruta = "/resources/images/" + linea.getNombre_linea();

			// System.out.println("ruta: " + ruta);
			LOGGER.info("ruta primera foto: " + ruta);
			// System.out.println("rutax: " + rutax);

			String nombreImagen = Utileria.guardarImagenPlus(multiPart, request, ruta);
			linea.setFoto_linea(nombreImagen);

		}
		if (!multiPartx.isEmpty()) {
			String rutax = "/resources/images/" + linea.getFoto_ruta();

			// System.out.println("ruta: " + ruta);
			LOGGER.info("ruta segunda foto: " + rutax);
			// System.out.println("rutax: " + rutax);

			String nombreImagenx = Utileria.guardarImagenPlus(multiPartx, request, rutax);
			linea.setFoto_ruta(nombreImagenx);

		}
		linea.setVersion(timestamp);

		LOGGER.info("LINEA CREADA");

		linearepository.save(linea);

		return "LINEA CREADA";

	}

}