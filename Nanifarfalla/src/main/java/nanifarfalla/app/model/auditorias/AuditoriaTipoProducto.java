package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_tipo_producto")
public class AuditoriaTipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_auditipoproducto;
	String usuario;
	Date fecha_cambio;
	String nombre_tipoproducto_old;
	Double tiempo_produccion_old;
	Double precio_costo_old;
	String foto_ruta_old;
	String claveApi_old;
	Date version_old;
	String nombre_tipoproducto_new;
	Double tiempo_produccion_new;
	Double precio_costo_new;
	String foto_ruta_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaTipoProducto() {

	}

	public int getCodigo_auditipoproducto() {
		return codigo_auditipoproducto;
	}

	public void setCodigo_auditipoproducto(int codigo_auditipoproducto) {
		this.codigo_auditipoproducto = codigo_auditipoproducto;
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

	public String getNombre_tipoproducto_old() {
		return nombre_tipoproducto_old;
	}

	public void setNombre_tipoproducto_old(String nombre_tipoproducto_old) {
		this.nombre_tipoproducto_old = nombre_tipoproducto_old;
	}

	public Double getTiempo_produccion_old() {
		return tiempo_produccion_old;
	}

	public void setTiempo_produccion_old(Double tiempo_produccion_old) {
		this.tiempo_produccion_old = tiempo_produccion_old;
	}

	public Double getPrecio_costo_old() {
		return precio_costo_old;
	}

	public void setPrecio_costo_old(Double precio_costo_old) {
		this.precio_costo_old = precio_costo_old;
	}

	public String getFoto_ruta_old() {
		return foto_ruta_old;
	}

	public void setFoto_ruta_old(String foto_ruta_old) {
		this.foto_ruta_old = foto_ruta_old;
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

	public String getNombre_tipoproducto_new() {
		return nombre_tipoproducto_new;
	}

	public void setNombre_tipoproducto_new(String nombre_tipoproducto_new) {
		this.nombre_tipoproducto_new = nombre_tipoproducto_new;
	}

	public Double getTiempo_produccion_new() {
		return tiempo_produccion_new;
	}

	public void setTiempo_produccion_new(Double tiempo_produccion_new) {
		this.tiempo_produccion_new = tiempo_produccion_new;
	}

	public Double getPrecio_costo_new() {
		return precio_costo_new;
	}

	public void setPrecio_costo_new(Double precio_costo_new) {
		this.precio_costo_new = precio_costo_new;
	}

	public String getFoto_ruta_new() {
		return foto_ruta_new;
	}

	public void setFoto_ruta_new(String foto_ruta_new) {
		this.foto_ruta_new = foto_ruta_new;
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
