package nanifarfalla.app.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import nanifarfalla.app.model.Producto;
import nanifarfalla.app.service.IProductoService;
@Service
public class ProductoServiceImpl implements IProductoService {
	private List<Producto> lista = null;

	public ProductoServiceImpl() {
		System.out.println("Creando una instancia de la clase LineasServiceImpl");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		try {
		
			lista = new LinkedList<Producto>();
			Producto producto1 = new Producto();
			producto1.setCodigo_producto(1);
			producto1.setNombre_producto("caballero de Huari");
			producto1.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto1.setSalida_almacen(formatter.parse("18-11-2019"));
			producto1.setStock_producto(67);
			producto1.setPreparacion_producto("preparacion caballero de Huari");
			producto1.setFoto_ruta("nanifarfalla.jpg");
			producto1.setColores_producto("Amarillo,Rojo,Azul");
			producto1.setQr_producto("ruta del qr");
			producto1.setPpv_producto(90.8);
			producto1.setPvf_producto(68.3);
			producto1.setClaveApi("clave APi");
			producto1.setVersion(formatter.parse("18-11-2019"));
			producto1.setFkcodigo_linea(3);
			
			Producto producto2 = new Producto();
			producto2.setCodigo_producto(2);
			producto2.setNombre_producto("Producto 2 Nanifarfalla");
			producto2.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto2.setSalida_almacen(formatter.parse("18-11-2019"));
			producto2.setStock_producto(120);
			producto2.setPreparacion_producto("preparacion Producto 2 Nanifarfalla");
			producto2.setFoto_ruta("nanifarfalla.jpg");
			producto2.setColores_producto("turquesa,violeta,oro,plato");
			producto2.setQr_producto("ruta del qr");
			producto2.setPpv_producto(150.8);
			producto2.setPvf_producto(68.3);
			producto2.setClaveApi("clave APi");
			producto2.setVersion(formatter.parse("18-11-2019"));
			producto2.setFkcodigo_linea(3);
			
			Producto producto3 = new Producto();
			producto3.setCodigo_producto(3);
			producto3.setNombre_producto("Producto 3 Nanifarfalla");
			producto3.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto3.setSalida_almacen(formatter.parse("18-11-2019"));
			producto3.setStock_producto(67);
			producto3.setPreparacion_producto("preparacion Producto 3");
			producto3.setFoto_ruta("nanifarfalla.jpg");
			producto3.setColores_producto("Amarillo,Rojo,Azul");
			producto3.setQr_producto("ruta del qr");
			producto3.setPpv_producto(90.8);
			producto3.setPvf_producto(68.3);
			producto3.setClaveApi("clave APi");
			producto3.setVersion(formatter.parse("18-11-2019"));
			producto3.setFkcodigo_linea(1);
			
			
			Producto producto4 = new Producto();
			producto4.setCodigo_producto(4);
			producto4.setNombre_producto("Producto 4 Nanifarfalla");
			producto4.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto4.setSalida_almacen(formatter.parse("18-11-2019"));
			producto4.setStock_producto(120);
			producto4.setPreparacion_producto("preparacion Producto 4 Nanifarfalla");
			producto4.setFoto_ruta("nanifarfalla.jpg");
			producto4.setColores_producto("turquesa,violeta,oro,plato");
			producto4.setQr_producto("ruta del qr");
			producto4.setPpv_producto(150.8);
			producto4.setPvf_producto(68.3);
			producto4.setClaveApi("clave APi");
			producto4.setVersion(formatter.parse("18-11-2019"));
			producto4.setFkcodigo_linea(1);
			
			
			
			Producto producto5 = new Producto();
			producto5.setCodigo_producto(5);
			producto5.setNombre_producto("Producto 5 nanifarfalla");
			producto5.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto5.setSalida_almacen(formatter.parse("18-11-2019"));
			producto5.setStock_producto(67);
			producto5.setPreparacion_producto("Producto 5 ");
			producto5.setFoto_ruta("nanifarfalla.jpg");
			producto5.setColores_producto("Amarillo,Rojo,Azul");
			producto5.setQr_producto("ruta del qr");
			producto5.setPpv_producto(90.8);
			producto5.setPvf_producto(68.3);
			producto5.setClaveApi("clave APi");
			producto5.setVersion(formatter.parse("18-11-2019"));
			producto5.setFkcodigo_linea(2);
			
			Producto producto6 = new Producto();
			producto6.setCodigo_producto(6);
			producto6.setNombre_producto("Producto 6 Nanifarfalla");
			producto6.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto6.setSalida_almacen(formatter.parse("18-11-2019"));
			producto6.setStock_producto(120);
			producto6.setPreparacion_producto("preparacion Producto 6 Nanifarfalla");
			producto6.setFoto_ruta("nanifarfalla.jpg");
			producto6.setColores_producto("turquesa,violeta,oro,plato");
			producto6.setQr_producto("ruta del qr");
			producto6.setPpv_producto(150.8);
			producto6.setPvf_producto(68.3);
			producto6.setClaveApi("clave APi");
			producto6.setVersion(formatter.parse("18-11-2019"));
			producto6.setFkcodigo_linea(2);
			
			
			Producto producto7 = new Producto();
			producto7.setCodigo_producto(7);
			producto7.setNombre_producto("Producto 7 Nanifarfalla");
			producto7.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto7.setSalida_almacen(formatter.parse("18-11-2019"));
			producto7.setStock_producto(67);
			producto7.setPreparacion_producto("preparacion Producto 7 Nanifarafallla");
			producto7.setFoto_ruta("nanifarfalla.jpg");
			producto7.setColores_producto("Amarillo,Rojo,Azul");
			producto7.setQr_producto("ruta del qr");
			producto7.setPpv_producto(90.8);
			producto7.setPvf_producto(68.3);
			producto7.setClaveApi("clave APi");
			producto7.setVersion(formatter.parse("18-11-2019"));
			producto7.setFkcodigo_linea(2);
			
			Producto producto8 = new Producto();
			producto8.setCodigo_producto(8);
			producto8.setNombre_producto("Producto 8 Nanifarfalla");
			producto8.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto8.setSalida_almacen(formatter.parse("18-11-2019"));
			producto8.setStock_producto(120);
			producto8.setPreparacion_producto("preparacion Producto 8 Nanifarfalla");
			producto8.setFoto_ruta("nanifarfalla.jpg");
			producto8.setColores_producto("turquesa,violeta,oro,plato");
			producto8.setQr_producto("ruta del qr");
			producto8.setPpv_producto(150.8);
			producto8.setPvf_producto(68.3);
			producto8.setClaveApi("clave APi");
			producto8.setVersion(formatter.parse("18-11-2019"));
			producto8.setFkcodigo_linea(2);
			
			Producto producto9 = new Producto();
			producto9.setCodigo_producto(9);
			producto9.setNombre_producto("Producto 9 Nanifarfalla");
			producto9.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto9.setSalida_almacen(formatter.parse("18-11-2019"));
			producto9.setStock_producto(67);
			producto9.setPreparacion_producto("preparacion caballero de Huari");
			producto9.setFoto_ruta("nanifarfalla.jpg");
			producto9.setColores_producto("Amarillo,Rojo,Azul");
			producto9.setQr_producto("ruta del qr");
			producto9.setPpv_producto(90.8);
			producto9.setPvf_producto(68.3);
			producto9.setClaveApi("clave APi");
			producto9.setVersion(formatter.parse("18-11-2019"));
			producto9.setFkcodigo_linea(2);
			
			Producto producto10 = new Producto();
			producto10.setCodigo_producto(10);
			producto10.setNombre_producto("Producto 10 Nanifarfalla");
			producto10.setIngreso_almacen(formatter.parse("18-11-2019"));
			producto10.setSalida_almacen(formatter.parse("18-11-2019"));
			producto10.setStock_producto(120);
			producto10.setPreparacion_producto("preparacion Producto 10 Nanifarfalla");
			producto10.setFoto_ruta("nanifarfalla.jpg");
			producto10.setColores_producto("turquesa,violeta,oro,plato");
			producto10.setQr_producto("ruta del qr");
			producto10.setPpv_producto(150.8);
			producto10.setPvf_producto(68.3);
			producto10.setClaveApi("clave APi");
			producto10.setVersion(formatter.parse("18-11-2019"));
			producto10.setFkcodigo_linea(1);
			
			
			
			lista.add(producto1);
			lista.add(producto2);
			lista.add(producto3);
			lista.add(producto4);
			lista.add(producto5);
			lista.add(producto6);
			lista.add(producto7);
			lista.add(producto8);
			lista.add(producto9);
			lista.add(producto10);

		} catch (ParseException ex) {
			System.out.println("Error: " + ex.getMessage());

		}
	}

	@Override
	public List<Producto> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Producto buscarPorId(int idProducto) {
		for (Producto p : lista) {
			if (p.getCodigo_producto() == idProducto) {
				return p;

			}
		}
		return null;
	}

	@Override
	public void inserta(Producto producto) {
		// TODO Auto-generated method stub
		lista.add(producto);

	}

	@Override
	public Page<Producto> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		
//return productoRepo.findAll(page);		
		return null;
	}

}
