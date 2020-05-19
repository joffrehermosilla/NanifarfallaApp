package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_elaboracionproducto")
public class AuditoriaElaboracionProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audielaboracionproducto;
	String usuario;
	Date fecha_cambio;
	String modelo_producto_old;
	String temporada_producto_old;
	String claveApi_old;
	Date version_old;
	String modelo_producto_new;
	String temporada_producto_new;
	String claveApi_new;
	Date version_new;
	
	public int getCodigo_audielaboracionproducto() {
		return codigo_audielaboracionproducto;
	}
	public void setCodigo_audielaboracionproducto(int codigo_audielaboracionproducto) {
		this.codigo_audielaboracionproducto = codigo_audielaboracionproducto;
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
	public String getModelo_producto_old() {
		return modelo_producto_old;
	}
	public void setModelo_producto_old(String modelo_producto_old) {
		this.modelo_producto_old = modelo_producto_old;
	}
	public String getTemporada_producto_old() {
		return temporada_producto_old;
	}
	public void setTemporada_producto_old(String temporada_producto_old) {
		this.temporada_producto_old = temporada_producto_old;
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
	public String getModelo_producto_new() {
		return modelo_producto_new;
	}
	public void setModelo_producto_new(String modelo_producto_new) {
		this.modelo_producto_new = modelo_producto_new;
	}
	public String getTemporada_producto_new() {
		return temporada_producto_new;
	}
	public void setTemporada_producto_new(String temporada_producto_new) {
		this.temporada_producto_new = temporada_producto_new;
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
	public AuditoriaElaboracionProducto() {
	
	}


}
