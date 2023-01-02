package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.Producto;
import nanifarfalla.app.web.dto.LineaDto;


public interface ILineasService  {

	
	Linea buscarPorId(int idLinea);

	void inserta(Linea linea);
	List<Producto> findProductobyLineaIdParamsNative(int idLinea);
	List<Linea> findBycodigo_linea(int codigo_linea);
	List<Linea> findByid_linea( int id);
	 
    String registerLineaString(LineaDto lineaDto, int active,
    		MultipartFile multiPart,MultipartFile multiPartx,HttpServletRequest request,Authentication authentication);
	
	 
    String registroLineaString(LineaDto lineaDto, int active,
    		MultipartFile multiPart,MultipartFile multiPartx,HttpServletRequest request);
	
	Linea get(int id);
	List<Linea> list();
	boolean add(Linea category);
	boolean update(Linea category);
	boolean delete(Linea category);
	
	void eliminar(int idLinea);

	Optional<Linea> buscarporId(int id);

	String findRutaFicheroSesion(String usernamex);
	
	//Siempre agregar la paginación
	Page<Linea> buscarTodas(Pageable page);
	List<Linea> buscarTodas();
	
}
