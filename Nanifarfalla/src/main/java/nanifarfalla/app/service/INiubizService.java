package nanifarfalla.app.service;

import nanifarfalla.app.model.AutorizacionResponse;
import nanifarfalla.app.model.AutorizacionResquest;
import nanifarfalla.app.model.SeguridadResponse;
import nanifarfalla.app.model.SesionRequest;
import nanifarfalla.app.model.SesionResponse;

public interface INiubizService {

	public SeguridadResponse seguridadPagoNiubiz();

	public SesionResponse sesionPagoNiubiz(SesionRequest request);

	public AutorizacionResponse autorizacionPagoNiubiz(AutorizacionResquest request);
}
