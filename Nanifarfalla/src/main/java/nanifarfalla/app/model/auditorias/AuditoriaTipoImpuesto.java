package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_tipo_impuesto")
public class AuditoriaTipoImpuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_tipo_impuesto;
	String usuario;
	Date fecha_cambio;
	String nombre_tipo_impuesto_old;
	Double porcentaje_tipo_impuesto_old;
	String claveApi_old;
	Date version_old;
	String nombre_tipo_impuesto_new;
	Double porcentaje_tipo_impuesto_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaTipoImpuesto() {

	}

	public int getCodigo_audi_tipo_impuesto() {
		return codigo_audi_tipo_impuesto;
	}

	public void setCodigo_audi_tipo_impuesto(int codigo_audi_tipo_impuesto) {
		this.codigo_audi_tipo_impuesto = codigo_audi_tipo_impuesto;
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

	public String getNombre_tipo_impuesto_old() {
		return nombre_tipo_impuesto_old;
	}

	public void setNombre_tipo_impuesto_old(String nombre_tipo_impuesto_old) {
		this.nombre_tipo_impuesto_old = nombre_tipo_impuesto_old;
	}

	public Double getPorcentaje_tipo_impuesto_old() {
		return porcentaje_tipo_impuesto_old;
	}

	public void setPorcentaje_tipo_impuesto_old(Double porcentaje_tipo_impuesto_old) {
		this.porcentaje_tipo_impuesto_old = porcentaje_tipo_impuesto_old;
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

	public String getNombre_tipo_impuesto_new() {
		return nombre_tipo_impuesto_new;
	}

	public void setNombre_tipo_impuesto_new(String nombre_tipo_impuesto_new) {
		this.nombre_tipo_impuesto_new = nombre_tipo_impuesto_new;
	}

	public Double getPorcentaje_tipo_impuesto_new() {
		return porcentaje_tipo_impuesto_new;
	}

	public void setPorcentaje_tipo_impuesto_new(Double porcentaje_tipo_impuesto_new) {
		this.porcentaje_tipo_impuesto_new = porcentaje_tipo_impuesto_new;
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
