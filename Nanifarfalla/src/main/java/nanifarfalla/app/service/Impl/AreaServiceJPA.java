package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Area;
import nanifarfalla.app.repository.AreaRepository;
import nanifarfalla.app.service.IAreaService;



import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AreaServiceJPA implements IAreaService{

	@Autowired
	AreaRepository arearepository;
	
	
	
	
	
	
	@Override
	public void inserta(Area area) {
		// TODO Auto-generated method stub
		arearepository.save(area);
	}

	@Override
	public void actualiza(Area area) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(Area area) {
		// TODO Auto-generated method stub
		arearepository.delete(area);
	}

	@Override
	public Area get(int areaId) {
		// TODO Auto-generated method stub
		return arearepository.getOne(areaId);
	}

	@Override
	public List<Area> list() {
		// TODO Auto-generated method stub
		return arearepository.findAll();
	}

	@Override
	public boolean add(Area area) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Area area) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Area area) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Area> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return arearepository.findAll(page);
	}

	@Override
	public List<Area> buscarTodas() {
		// TODO Auto-generated method stub
		return arearepository.findAll();
	}

}
