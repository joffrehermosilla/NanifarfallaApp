package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.PromocionVenta;

public interface IPromocionVentaService {

	void inserta(PromocionVenta promocionVenta);
	void actualiza(PromocionVenta promocionVenta);
	void elimina(PromocionVenta promocionVenta);
		
	PromocionVenta get(int promocionVentaId);
	List<PromocionVenta> list();	
	boolean add(PromocionVenta promocionVenta);
	boolean update(PromocionVenta promocionVenta);
	boolean delete(PromocionVenta promocionVenta);
		
	Page<PromocionVenta> buscarTodas(Pageable page);
	List<PromocionVenta> buscarTodas();
}
