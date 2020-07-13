package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_estado_contrato")
public class AuditoriaEstadoContrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_estado_contrato;
	String usuario;
	Date fecha_cambio;
	String descripcion_old;
	String claveApi_old;
	Date version_old;
	String descripcion_new;
	String claveApi_new;
	Date version_new;
	
	
	public AuditoriaEstadoContrato() {
		
	}
	public int getCodigo_audi_estado_contrato() {
		return codigo_audi_estado_contrato;
	}
	public void setCodigo_audi_estado_contrato(int codigo_audi_estado_contrato) {
		this.codigo_audi_estado_contrato = codigo_audi_estado_contrato;
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
	public String getDescripcion_old() {
		return descripcion_old;
	}
	public void setDescripcion_old(String descripcion_old) {
		this.descripcion_old = descripcion_old;
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
	public String getDescripcion_new() {
		return descripcion_new;
	}
	public void setDescripcion_new(String descripcion_new) {
		this.descripcion_new = descripcion_new;
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
