package nanifarfalla.app.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Anuncio;

import nanifarfalla.app.service.IAnunciosService;

@Service
public class AnunciosServiceImpl implements IAnunciosService {

	private List<Anuncio> lista = null;

	public AnunciosServiceImpl() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {

			lista = new LinkedList<Anuncio>();
			Anuncio anuncio1 = new Anuncio();
			anuncio1.setCodigo_anuncio(1);
			anuncio1.setAnuncio_principal("Este Anuncio principal 1");
			//anuncio1.setFkcodigo_tipoalerta(1);
			anuncio1.setLink_mensaje("http://facebook");
			anuncio1.setMensaje_anuncio("importante");
			anuncio1.setPie_mensaje("prueba 1");
			anuncio1.setPrecio(9.0);
			anuncio1.setRuta_imagen("nanifarfalla.jpeg");
			anuncio1.setVersion(formatter.parse("18-11-2019"));

			Anuncio anuncio2 = new Anuncio();
			anuncio2.setCodigo_anuncio(2);
			anuncio2.setAnuncio_principal("Este Anuncio principal 2");
			//anuncio2.setFkcodigo_tipoalerta(2);
			anuncio2.setLink_mensaje("http://facebook");
			anuncio2.setMensaje_anuncio("info");
			anuncio2.setPie_mensaje("prueba 2");
			anuncio2.setPrecio(9.0);
			anuncio2.setRuta_imagen("nanifarfalla.jpeg");
			anuncio2.setVersion(formatter.parse("18-11-2019"));

			Anuncio anuncio3 = new Anuncio();
			anuncio3.setCodigo_anuncio(3);
			anuncio3.setAnuncio_principal("Este Anuncio principal 3");
		//	anuncio3.setFkcodigo_tipoalerta(3);
			anuncio3.setLink_mensaje("http://facebook");
			anuncio3.setMensaje_anuncio("alerta");
			anuncio3.setPie_mensaje("prueba 3");
			anuncio3.setPrecio(9.0);
			anuncio3.setRuta_imagen("nanifarfalla.jpeg");
			anuncio3.setVersion(formatter.parse("18-11-2019"));

			Anuncio anuncio4 = new Anuncio();
			anuncio4.setCodigo_anuncio(4);
			anuncio4.setAnuncio_principal("Este Anuncio principal 4");
		//	anuncio4.setFkcodigo_tipoalerta(4);
			anuncio4.setLink_mensaje("http://facebook");
			anuncio4.setMensaje_anuncio("evento");
			anuncio4.setPie_mensaje("prueba 4");
			anuncio4.setPrecio(9.0);
			anuncio4.setRuta_imagen("nanifarfalla.jpeg");
			anuncio4.setVersion(formatter.parse("18-11-2019"));

			lista.add(anuncio1);
			lista.add(anuncio2);
			lista.add(anuncio3);
			lista.add(anuncio4);

		} catch (ParseException ex) {
			System.out.println("Error: " + ex.getMessage());

		}

	}

	public void inserta(Anuncio anuncio) {
		lista.add(anuncio);

	}

	public List<Anuncio> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	public void guardar(Anuncio anuncio) {
		// TODO Auto-generated method stub
		lista.add(anuncio);

	}

	public Anuncio buscarporId(int idAnuncio) {
		for (Anuncio a : lista) {
			if (a.getCodigo_anuncio() == idAnuncio) {
				return a;
			}
		}
		return null;
	}

}
