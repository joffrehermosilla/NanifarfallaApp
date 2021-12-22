package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.FacturaClienteTienePedido;
import nanifarfalla.app.repository.FacturaClienteTienePedidoRepository;

import nanifarfalla.app.service.IFacturaCTienePedidoService;

@Service
public class FacturaCTienePedidoServiceJPA implements IFacturaCTienePedidoService{

	@Autowired
	FacturaClienteTienePedidoRepository facCTienePedidoRepository;
	
	@Override
	public void inserta(FacturaClienteTienePedido facturaClienteTienePedido) {
		facCTienePedidoRepository.save(facturaClienteTienePedido);
		
	}

	@Override
	public void actualiza(FacturaClienteTienePedido facturaClienteTienePedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(FacturaClienteTienePedido facturaClienteTienePedido) {
		facCTienePedidoRepository.delete(facturaClienteTienePedido);
		
	}

	@Override
	public FacturaClienteTienePedido get(int facturaClienteTienePedidoId) {
		return facCTienePedidoRepository.getOne(facturaClienteTienePedidoId);
	}

	@Override
	public List<FacturaClienteTienePedido> list() {
		return facCTienePedidoRepository.findAll();
	}

	@Override
	public boolean add(FacturaClienteTienePedido facturaClienteTienePedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(FacturaClienteTienePedido facturaClienteTienePedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(FacturaClienteTienePedido facturaClienteTienePedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<FacturaClienteTienePedido> buscarTodas(Pageable page) {
		return facCTienePedidoRepository.findAll(page);
	}

	@Override
	public List<FacturaClienteTienePedido> buscarTodas() {
		return facCTienePedidoRepository.findAll();
	}

}
