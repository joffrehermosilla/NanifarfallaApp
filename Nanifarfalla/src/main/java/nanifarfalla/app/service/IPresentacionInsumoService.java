package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.PresentacionInsumo;

public interface IPresentacionInsumoService {

	void inserta(PresentacionInsumo presentacionInsumo);
	void actualiza(PresentacionInsumo presentacionInsumo);
	void elimina(PresentacionInsumo presentacionInsumo);
		
	PresentacionInsumo get(int presentacionInsumoId);
	List<PresentacionInsumo> list();	
	boolean add(PresentacionInsumo presentacionInsumo);
	boolean update(PresentacionInsumo presentacionInsumo);
	boolean delete(PresentacionInsumo presentacionInsumo);
		
	Page<PresentacionInsumo> buscarTodas(Pageable page);
	List<PresentacionInsumo> buscarTodas();
}
