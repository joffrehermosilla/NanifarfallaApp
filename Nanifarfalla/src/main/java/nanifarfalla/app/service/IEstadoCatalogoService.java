package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoCatalogo;

public interface IEstadoCatalogoService {

	void inserta(EstadoCatalogo estadocatalogo);

	void actualiza(EstadoCatalogo estadocatalogo);

	void elimina(EstadoCatalogo estadocatalogo);

	EstadoCatalogo get(int estadoCatalogoId);

	List<EstadoCatalogo> list();

	boolean add(EstadoCatalogo estadocatalogo);

	boolean update(EstadoCatalogo estadocatalogo);

	boolean delete(EstadoCatalogo estadocatalogo);

	void eliminar(int idEstadoCatalogo);

	Optional<EstadoCatalogo> buscarporId(int id);

	// Siempre agregar la paginación
	Page<EstadoCatalogo> buscarTodas(Pageable page);

	List<EstadoCatalogo> buscarTodas();

}
