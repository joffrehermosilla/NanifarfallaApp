package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Privilege;

public interface IPrivelegeService {

	// Creación de CRUD con el formato Standard

	void inserta(Privilege privelege);


	void elimina(Privilege privelege);

	Privilege get(int privelegeId);

	List<Privilege> list();


	// Siempre agregar la paginación
	Page<Privilege> buscarTodas(Pageable page);

	List<Privilege> buscarTodas();

	// Creación de CRUD con el formato Standard

	// Siempre agregar la paginación



	void eliminar(int privelegeId);

	Optional<Privilege> buscarporId(int id);
}
