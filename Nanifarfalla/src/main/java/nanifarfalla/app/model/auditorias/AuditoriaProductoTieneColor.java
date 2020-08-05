package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "audi_producto_tiene_color")
public class AuditoriaProductoTieneColor {
	int codigo_audiproducto_tienecolor;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_color_old;
	int fkcodigo_producto_old;
	String claveApi_old;
	Date version_old;
	int fkcodigo_color_new;
	int fkcodigo_producto_new;
	String claveApi_new;
	Date version_new;

	public int getCodigo_audiproducto_tienecolor() {
		return codigo_audiproducto_tienecolor;
	}

	public void setCodigo_audiproducto_tienecolor(int codigo_audiproducto_tienecolor) {
		this.codigo_audiproducto_tienecolor = codigo_audiproducto_tienecolor;
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

	public int getFkcodigo_color_old() {
		return fkcodigo_color_old;
	}

	public void setFkcodigo_color_old(int fkcodigo_color_old) {
		this.fkcodigo_color_old = fkcodigo_color_old;
	}

	public int getFkcodigo_producto_old() {
		return fkcodigo_producto_old;
	}

	public void setFkcodigo_producto_old(int fkcodigo_producto_old) {
		this.fkcodigo_producto_old = fkcodigo_producto_old;
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

	public int getFkcodigo_color_new() {
		return fkcodigo_color_new;
	}

	public void setFkcodigo_color_new(int fkcodigo_color_new) {
		this.fkcodigo_color_new = fkcodigo_color_new;
	}

	public int getFkcodigo_producto_new() {
		return fkcodigo_producto_new;
	}

	public void setFkcodigo_producto_new(int fkcodigo_producto_new) {
		this.fkcodigo_producto_new = fkcodigo_producto_new;
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

	public AuditoriaProductoTieneColor() {

	}

}
