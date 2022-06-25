package nanifarfalla.app.service.Impl;

import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import nanifarfalla.app.model.AutorizacionResponse;
import nanifarfalla.app.model.AutorizacionResquest;
import nanifarfalla.app.model.SeguridadResponse;
import nanifarfalla.app.model.SesionRequest;
import nanifarfalla.app.model.SesionResponse;
import nanifarfalla.app.service.INiubizService;
import nanifarfalla.app.util.Constantes;
import nanifarfalla.app.util.Utileria;

@Service("iNiubizService")
public class NiubizServiceImpl implements INiubizService{

	private RestTemplate restTemplate;
	
	@Value("${api.seguridad.niubiz}")
	String urlSeguridad;
	
	@Value("${api.sesion.niubiz}")
	String urlSesion;
	
	@Value("${api.autorizacion.niubiz}")
	String urlAutorizacion;
	
	@Value("${codigo.comercio}")	
	String codComercio;	
	
	@Value("${usuario}")	
	String usuarioSeg;
	
	@Value("${pass}")	
	String passSeg;
	
	
	/**
	 * Esta API permitirá generar un token de sesion para levantar formulario de pagos. 
	 */	
	@Override
	public SesionResponse sesionPagoNiubiz(SesionRequest request) {
		SesionResponse responseSess=new SesionResponse();

		String requestJson = Utileria.printPrettyJSONString(request);
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constantes.HEADER_AUTHORIZATION, request.getAccessToken());

		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

		ResponseEntity<SesionResponse> response = restTemplate.exchange(
				urlSesion+codComercio, HttpMethod.POST, entity,
				SesionResponse.class);

		String responseJson = Utileria.printPrettyJSONString(response.getBody());
		System.out.println("Response API Sesion: "+responseJson);
		responseSess=response.getBody();

		return responseSess;
	}
	
	/**
	 * Esta API permitirá realizar una operación de venta con una tarjeta. 
	 */
	@Override
	public AutorizacionResponse autorizacionPagoNiubiz(AutorizacionResquest request) {
		AutorizacionResponse responseAuth=new AutorizacionResponse();

		String requestJson = Utileria.printPrettyJSONString(request);
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set(Constantes.HEADER_AUTHORIZATION, request.getAccessToken());

		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);

		ResponseEntity<AutorizacionResponse> response = restTemplate.exchange(
				urlAutorizacion+codComercio, HttpMethod.POST, entity,
				AutorizacionResponse.class);

		String responseJson = Utileria.printPrettyJSONString(response.getBody());
		System.out.println("Response API Autorizacion: "+responseJson);
		responseAuth=response.getBody();

		return responseAuth;
	}

	/**
	 * Esta API permitirá generar un token de acceso, el cual será utilizado en la llamada de otras APIs funcionales. 
	 */
	@Override
	public SeguridadResponse seguridadPagoNiubiz() {
		SeguridadResponse responseSeg=new SeguridadResponse();
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		String originalCredenciales = usuarioSeg+":"+passSeg;
		String encoded = Base64.getEncoder().encodeToString(originalCredenciales.getBytes());
		headers.set(Constantes.HEADER_AUTHORIZATION, "Basic "+encoded);

		HttpEntity<SeguridadResponse> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(
				urlSeguridad, HttpMethod.GET, entity,
				String.class);

		System.out.println("Response API Seguridad: "+response.getBody());
		responseSeg.setAccessToken(response.getBody());

		return responseSeg;
	}

}
