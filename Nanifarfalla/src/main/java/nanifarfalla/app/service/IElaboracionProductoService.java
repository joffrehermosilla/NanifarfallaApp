package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.ElaboracionProducto;

public interface IElaboracionProductoService {

	void inserta(ElaboracionProducto elaboracionProducto);

	void actualiza(ElaboracionProducto elaboracionProducto);

	void elimina(ElaboracionProducto elaboracionProducto);

	void eliminar(int idElaboracionProducto);

	Optional<ElaboracionProducto> buscarporId(int id);

	ElaboracionProducto get(int elaboracionProductoId);

	List<ElaboracionProducto> list();

	boolean add(ElaboracionProducto elaboracionProducto);

	boolean update(ElaboracionProducto elaboracionProducto);

	boolean delete(ElaboracionProducto elaboracionProducto);

	Page<ElaboracionProducto> buscarTodas(Pageable page);

	List<ElaboracionProducto> buscarTodas();
}
