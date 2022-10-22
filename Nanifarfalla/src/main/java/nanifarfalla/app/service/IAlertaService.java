package nanifarfalla.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.Alerta;

public interface IAlertaService {

	void inserta(Alerta alerta);

	List<Alerta> buscarTodas();

	void guardar(Alerta alerta);

	void actualiza(Alerta alerta);

	void elimina(Alerta alerta);

	void eliminar(int idAlerta);

	Optional<Alerta> buscarporId(int id);

	Alerta get(int alertagetId);

	List<Alerta> list();

	boolean add(Alerta alerta);

	boolean update(Alerta alerta);

	boolean delete(Alerta alerta);

	Page<Alerta> buscarTodas(Pageable page);

}
