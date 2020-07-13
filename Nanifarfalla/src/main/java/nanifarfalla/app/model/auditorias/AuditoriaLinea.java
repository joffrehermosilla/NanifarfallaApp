package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_linea")
public class AuditoriaLinea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_linea;
	String usuario;
	Date fecha_cambio;
	String nombre_linea_old;
	String foto_linea_old;
	String claveApi_old;
	Date version_old;
	String nombre_linea_new;
	String foto_linea_new;
	String claveApi_new;
	Date version_new;
	
	
	
	public AuditoriaLinea() {
		
	}
	public int getCodigo_audi_linea() {
		return codigo_audi_linea;
	}
	public void setCodigo_audi_linea(int codigo_audi_linea) {
		this.codigo_audi_linea = codigo_audi_linea;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha_cambio() {
		return fecha_cambio;
	}
	public void setFecha_cambio(Date fecha_cambio) {
		this.fecha_cambio = fecha_cambio;
	}
	public String getNombre_linea_old() {
		return nombre_linea_old;
	}
	public void setNombre_linea_old(String nombre_linea_old) {
		this.nombre_linea_old = nombre_linea_old;
	}
	public String getFoto_linea_old() {
		return foto_linea_old;
	}
	public void setFoto_linea_old(String foto_linea_old) {
		this.foto_linea_old = foto_linea_old;
	}
	public String getClaveApi_old() {
		return claveApi_old;
	}
	public void setClaveApi_old(String claveApi_old) {
		this.claveApi_old = claveApi_old;
	}
	public Date getVersion_old() {
		return version_old;
	}
	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}
	public String getNombre_linea_new() {
		return nombre_linea_new;
	}
	public void setNombre_linea_new(String nombre_linea_new) {
		this.nombre_linea_new = nombre_linea_new;
	}
	public String getFoto_linea_new() {
		return foto_linea_new;
	}
	public void setFoto_linea_new(String foto_linea_new) {
		this.foto_linea_new = foto_linea_new;
	}
	public String getClaveApi_new() {
		return claveApi_new;
	}
	public void setClaveApi_new(String claveApi_new) {
		this.claveApi_new = claveApi_new;
	}
	public Date getVersion_new() {
		return version_new;
	}
	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}
	
	
	

}
