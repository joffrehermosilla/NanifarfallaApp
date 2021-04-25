package nanifarfalla.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nanifarfalla.app.model.Producto;
import nanifarfalla.app.service.ILineasService;
import nanifarfalla.app.service.IProductoService;


@Controller
@RequestMapping("/json/data")
public class JsonDataController {


	@Autowired
	private IProductoService serviceProductos;

	@Autowired
	private ILineasService serviceLineas;
	

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Producto> getAllProductsList() {		
		return  serviceProductos.buscarTodas();
	//	return null;
				
	}	
	
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Producto> getAllProducts() {
		return serviceProductos.buscarTodas();
		//return null;
		//return productDAO.listActiveProducts();
				
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Producto> getProductsByCategory(@PathVariable int id) {
	//return serviceLineas.findProductobyLineaIdParamsNative(id);
    //return serviceProductos.getProductoByLinea(id);
	//	return productDAO.listActiveProductsByCategory(id);
		//return serviceProductos.BuscarLineaClaseconParam(id);
	//	return serviceProductos.findByFkcodigo_linea(id);
		
		return serviceProductos.findByLinea(id);
				
	}
	
	
	@RequestMapping("/mv/products")
	@ResponseBody
	public List<Producto> getMostViewedProducts() {
		return null;		
	//	return productDAO.getProductsByParam("views", 5);				
	}
		
	@RequestMapping("/mp/products")
	@ResponseBody
	public List<Producto> getMostPurchasedProducts() {
		return null;		
	//	return productDAO.getProductsByParam("purchases", 5);				
	}
	
	
	
	
}
