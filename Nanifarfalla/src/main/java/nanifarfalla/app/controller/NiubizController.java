package nanifarfalla.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nanifarfalla.app.model.AutorizacionResponse;
import nanifarfalla.app.model.AutorizacionResquest;
import nanifarfalla.app.model.SeguridadResponse;
import nanifarfalla.app.model.SesionRequest;
import nanifarfalla.app.model.SesionResponse;
import nanifarfalla.app.service.INiubizService;

@Controller
@RequestMapping(path = "/niubiz")
public class NiubizController {

	@Autowired
	@Qualifier("iNiubizService")
	private INiubizService niubizService;
	
	@Value("${channel.session}")	
	String canalSesion;
	
	@Value("${codigo.comercio}")	
	String codigoComercio;
	
	@GetMapping(path = "/seguridad")
	public SeguridadResponse seguridadPago() {
		System.out.println("Ingresa a metodo seguridad niubiz");		
		return niubizService.seguridadPagoNiubiz();
	}
	
	@PostMapping(value="/sesion")
	public SesionResponse sesionPago() {
		SesionRequest request=new SesionRequest();
		request.setChannel(canalSesion);
		request.setAmount("90.00");
		System.out.println("Ingresa a metodo sesion niubiz");
		return niubizService.sesionPagoNiubiz(request);
	}
	
	@PostMapping(value="/autorizacion")
	public AutorizacionResponse autorizacion() {
		AutorizacionResquest request=new AutorizacionResquest();

		System.out.println("Ingresa a metodo autorizacion niubiz");
		return niubizService.autorizacionPagoNiubiz(request);
	}
    
	@RequestMapping("/")
	public String iniciarFormulario(Model model) {
		System.out.println("***Inicio Formulario de Pagos***");

		System.out.println("***1. API de Seguridad***");
		SeguridadResponse seguridadResponse=niubizService.seguridadPagoNiubiz();
		model.addAttribute(seguridadResponse);
		
		System.out.println("***2. API de Sesion para JS***");
		SesionRequest sesionRequest=new SesionRequest();
		sesionRequest.setChannel(canalSesion);
		sesionRequest.setAmount("90.00");
		sesionRequest.setAccessToken(seguridadResponse.getAccessToken());
		
		SesionResponse sesionResponse= niubizService.sesionPagoNiubiz(sesionRequest);
		model.addAttribute(sesionResponse);
		
		model.addAttribute("canalSesion",canalSesion);
		model.addAttribute("codigoComercio",codigoComercio);
		
		Double montoTotal=90.0;
		model.addAttribute("montoTotal",montoTotal);
		return "inicio";
	}
	
	
	@RequestMapping("/confirmacion")
	public String confirmacion(Model model) {
		return "confirmacion";
	}
	
	@RequestMapping("/paginaError")
	public String error(Model model) {
		return "paginaError";
	}
}
