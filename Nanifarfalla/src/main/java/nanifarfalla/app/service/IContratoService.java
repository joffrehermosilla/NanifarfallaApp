package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Contrato;

public interface IContratoService {

	List<Contrato> buscartodos();

	void guardar(Contrato contrato);

	int lastcode();

	void inserta(Contrato contrato);

	void actualiza(Contrato contrato);

	void elimina(Contrato contrato);

	void eliminar(int idContrato);

	Optional<Contrato> buscarporId(int id);

	Contrato get(int contratoId);

	List<Contrato> list();

	boolean add(Contrato contrato);

	boolean update(Contrato contrato);

	boolean delete(Contrato contrato);

	Page<Contrato> buscarTodas(Pageable page);

	List<Contrato> buscarTodas();

}
