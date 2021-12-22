package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.LoteInsumo;

public interface ILoteInsumoService {
	void inserta(LoteInsumo loteInsumo);
	void actualiza(LoteInsumo loteInsumo);
	void elimina(LoteInsumo loteInsumo);
		
	LoteInsumo get(int loteInsumoId);
	List<LoteInsumo> list();	
	boolean add(LoteInsumo loteInsumo);
	boolean update(LoteInsumo loteInsumo);
	boolean delete(LoteInsumo loteInsumo);
		
	Page<LoteInsumo> buscarTodas(Pageable page);
	List<LoteInsumo> buscarTodas();
}
