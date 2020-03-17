package nanifarfalla.app.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Linea;
import nanifarfalla.app.service.ILineasService;

@Service
public class LineasServiceImpl implements ILineasService {

	private List<Linea> lista = null;

	public LineasServiceImpl() {

		System.out.println("Creando una instancia de la clase LineasServiceImpl");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		try {

			lista = new LinkedList<Linea>();
			Linea linea1 = new Linea();
			linea1.setCodigo_linea(1);
			linea1.setNombre_linea("Carteras");
			linea1.setFechacreacion(formatter.parse("18-11-2019"));
			linea1.setFoto_linea("nanifarfalla.jpeg");

			Linea linea2 = new Linea();
			linea2.setCodigo_linea(2);
			linea2.setNombre_linea("Mochilas");
			linea2.setFechacreacion(formatter.parse("10-01-2018"));
			linea2.setFoto_linea("mochilas.JPG");

			Linea linea3 = new Linea();
			linea3.setCodigo_linea(3);
			linea3.setNombre_linea("Neceser");
			linea3.setFechacreacion(formatter.parse("28-03-2020"));
			linea3.setFoto_linea("bolsos.JPG");

			Linea linea4 = new Linea();
			linea4.setCodigo_linea(4);
			linea4.setNombre_linea("Joyas");
			linea4.setFechacreacion(formatter.parse("29-11-1983"));
			linea4.setFoto_linea("joyas.JPG");

			lista.add(linea1);
			lista.add(linea2);
			lista.add(linea3);
			lista.add(linea4);

		} catch (ParseException ex) {
			System.out.println("Error: " + ex.getMessage());

		}

	}

	public List<Linea> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	public Linea buscarPorId(int idLinea) {
		for (Linea l : lista) {
			if (l.getCodigo_linea() == idLinea) {
				return l;

			}
		}
		return null;
	}


}
