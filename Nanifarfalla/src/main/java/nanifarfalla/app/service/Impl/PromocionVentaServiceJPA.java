package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.PromocionVenta;
import nanifarfalla.app.repository.PromocionVentaRepository;
import nanifarfalla.app.service.IPromocionVentaService;

@Service
public class PromocionVentaServiceJPA implements IPromocionVentaService{

	@Autowired
	PromocionVentaRepository promocionVentaRepository; 
	
	@Override
	public void inserta(PromocionVenta promocionVenta) {
		promocionVentaRepository.save(promocionVenta);
		
	}

	@Override
	public void actualiza(PromocionVenta promocionVenta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(PromocionVenta promocionVenta) {
		promocionVentaRepository.delete(promocionVenta);
		
	}

	@Override
	public PromocionVenta get(int promocionVentaId) {
		return promocionVentaRepository.getOne(promocionVentaId);
	}

	@Override
	public List<PromocionVenta> list() {
		return promocionVentaRepository.findAll();
	}

	@Override
	public boolean add(PromocionVenta promocionVenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PromocionVenta promocionVenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PromocionVenta promocionVenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<PromocionVenta> buscarTodas(Pageable page) {
		return promocionVentaRepository.findAll(page);
	}

	@Override
	public List<PromocionVenta> buscarTodas() {
		return promocionVentaRepository.findAll();
	}

}
