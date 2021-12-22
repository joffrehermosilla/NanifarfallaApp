package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.FacturaClienteTienePedido;
import nanifarfalla.app.service.IFacturaCTienePedidoService;

@Controller
@RequestMapping("/facctienepedido")
public class FacturaCTienePedidoController {

	@Autowired
	IFacturaCTienePedidoService IFacCTienePedidoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<FacturaClienteTienePedido> facctienepedido = IFacCTienePedidoService.buscarTodas();
		model.addAttribute("facctienepedidoy", facctienepedido);
		return "facctienepedido/listFacturaClienteTienePedido";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  FacturaClienteTienePedido facctienepedidos,Model model) {
		List<FacturaClienteTienePedido> facctienepedido = IFacCTienePedidoService.buscarTodas();
		model.addAttribute("facctienepedidoz", facctienepedido);
		return "facctienepedido/formFacturaClienteTienePedido";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute FacturaClienteTienePedido facctienepedido, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto FacturaClienteTienePedido: " + facctienepedido);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "facctienepedido/formFacturaClienteTienePedido";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto FacturaClienteTienePedido: " + facctienepedido);
		System.out.println("Elementos en la lista antes de la insersion: " + IFacCTienePedidoService.buscarTodas().size());
		
		IFacCTienePedidoService.inserta(facctienepedido);
		
		System.out.println("Elementos en la lista despues de la insersion: " + IFacCTienePedidoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El FacturaClienteTienePedido fue guardado");
		return "redirect:/facctienepedido/listFacturaClienteTienePedido";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<FacturaClienteTienePedido> lista = IFacCTienePedidoService.buscarTodas(page);
		model.addAttribute("facctienepedidox", lista);
		return "facctienepedido/listFacturaClienteTienePedido";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
