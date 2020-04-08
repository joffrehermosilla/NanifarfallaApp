package nanifarfalla.app.service;

import java.util.List;


import nanifarfalla.app.model.Producto;

public interface IProductoService {
	List<Producto> buscarTodas();
	
	Producto buscarPorId(int idProducto);

	void inserta(Producto producto);
}
