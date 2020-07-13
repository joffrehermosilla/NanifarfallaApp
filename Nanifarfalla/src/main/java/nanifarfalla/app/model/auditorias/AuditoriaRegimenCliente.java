package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_regimencliente")
public class AuditoriaRegimenCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audiregimencliente;
	String usuario;
	Date fecha_cambio;
	String nombre_regimencliente_old;
	String claveApi_old;
	Date version_old;
	String nombre_regimencliente_new;
	String claveApi_new;
	Date version_new;
	
	
	
	
	
	public AuditoriaRegimenCliente() {
	
	}
	public int getCodigo_audiregimencliente() {
		return codigo_audiregimencliente;
	}
	public void setCodigo_audiregimencliente(int codigo_audiregimencliente) {
		this.codigo_audiregimencliente = codigo_audiregimencliente;
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
	public String getNombre_regimencliente_old() {
		return nombre_regimencliente_old;
	}
	public void setNombre_regimencliente_old(String nombre_regimencliente_old) {
		this.nombre_regimencliente_old = nombre_regimencliente_old;
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
	public String getNombre_regimencliente_new() {
		return nombre_regimencliente_new;
	}
	public void setNombre_regimencliente_new(String nombre_regimencliente_new) {
		this.nombre_regimencliente_new = nombre_regimencliente_new;
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
