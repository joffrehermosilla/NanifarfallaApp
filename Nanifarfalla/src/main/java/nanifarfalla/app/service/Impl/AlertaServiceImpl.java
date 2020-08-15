package nanifarfalla.app.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Alerta;

import nanifarfalla.app.service.IAlertaService;

//@Service
public class AlertaServiceImpl implements IAlertaService {

	private List<Alerta> lista = null;

	public AlertaServiceImpl() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {

			lista = new LinkedList<Alerta>();

			Alerta alerta1 = new Alerta();

			alerta1.setCodigo_alerta(1);
			alerta1.setMensaje_alerta("Anuncio Importante");
			alerta1.setPrecio(3.5);
			alerta1.setCategoria("importante");
		//	alerta1.setFkcodigo_tipoalerta(1);
			alerta1.setVersion(formatter.parse("18-11-2019"));

			Alerta alerta2 = new Alerta();

			alerta2.setCodigo_alerta(2);
			alerta2.setMensaje_alerta("Anuncio Informativo");
			alerta2.setPrecio(3.5);
			alerta2.setCategoria("info");
			//alerta2.setFkcodigo_tipoalerta(2);
			alerta2.setVersion(formatter.parse("18-11-2019"));

			Alerta alerta3 = new Alerta();

			alerta3.setCodigo_alerta(3);
			alerta3.setMensaje_alerta("Anuncio alerta");
			alerta3.setPrecio(3.5);
			alerta3.setCategoria("alerta");
		//	alerta3.setFkcodigo_tipoalerta(3);
			alerta3.setVersion(formatter.parse("18-11-2019"));

			Alerta alerta4 = new Alerta();

			alerta4.setCodigo_alerta(4);
			alerta4.setMensaje_alerta("Anuncio evento");
			alerta4.setPrecio(3.5);
			alerta4.setCategoria("eventos");
		//	alerta4.setFkcodigo_tipoalerta(4);
			alerta4.setVersion(formatter.parse("18-11-2019"));

			lista.add(alerta1);
			lista.add(alerta2);
			lista.add(alerta3);
			lista.add(alerta4);

		} catch (ParseException ex) {
			System.out.println("Error: " + ex.getMessage());

		}

	}

	@Override
	public void inserta(Alerta alerta) {
		lista.add(alerta);

	}

	@Override
	public List<Alerta> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void guardar(Alerta alerta) {
		// TODO Auto-generated method stub
		lista.add(alerta);

	}

	@Override
	public Alerta buscarporId(int idAlerta) {
		for (Alerta a : lista) {
			if (a.getCodigo_alerta() == idAlerta) {
				return a;
			}
		}
		return null;
	}

}
