package nanifarfalla.app.service;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import nanifarfalla.app.model.DeviceMetadata;
import nanifarfalla.app.model.Usuario;

public interface IDataService {
	 void verifyDevice(Usuario user, HttpServletRequest request) throws IOException, GeoIp2Exception;
	 
	
	
	 

}
