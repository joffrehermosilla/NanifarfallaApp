package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_estadoproducto")
public class AuditoriaEstadoProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_estadoproducto;
	String usuario;
	Date fecha_cambio;
	String nombre_estado_producto_old;
	String claveApi_old;
	Date version_old;
	String nombre_estado_producto_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaEstadoProducto() {

	}

	public int getCodigo_audi_estadoproducto() {
		return codigo_audi_estadoproducto;
	}

	public void setCodigo_audi_estadoproducto(int codigo_audi_estadoproducto) {
		this.codigo_audi_estadoproducto = codigo_audi_estadoproducto;
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

	public String getNombre_estado_producto_old() {
		return nombre_estado_producto_old;
	}

	public void setNombre_estado_producto_old(String nombre_estado_producto_old) {
		this.nombre_estado_producto_old = nombre_estado_producto_old;
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

	public String getNombre_estado_producto_new() {
		return nombre_estado_producto_new;
	}

	public void setNombre_estado_producto_new(String nombre_estado_producto_new) {
		this.nombre_estado_producto_new = nombre_estado_producto_new;
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
