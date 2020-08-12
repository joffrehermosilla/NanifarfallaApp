package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_vendedor")
public class AuditoriaVendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_vendedor;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_usuario_old;
	int fkcodigo_area_old;
	String codigo_venta_vendedor_old;
	String claveApi_old;
	Date version_old;
	int fkcodigo_usuario_new;
	int fkcodigo_area_new;
	String codigo_venta_vendedor_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaVendedor() {

	}

	public int getCodigo_audi_vendedor() {
		return codigo_audi_vendedor;
	}

	public void setCodigo_audi_vendedor(int codigo_audi_vendedor) {
		this.codigo_audi_vendedor = codigo_audi_vendedor;
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

	public int getFkcodigo_usuario_old() {
		return fkcodigo_usuario_old;
	}

	public void setFkcodigo_usuario_old(int fkcodigo_usuario_old) {
		this.fkcodigo_usuario_old = fkcodigo_usuario_old;
	}

	public int getFkcodigo_area_old() {
		return fkcodigo_area_old;
	}

	public void setFkcodigo_area_old(int fkcodigo_area_old) {
		this.fkcodigo_area_old = fkcodigo_area_old;
	}

	public String getCodigo_venta_vendedor_old() {
		return codigo_venta_vendedor_old;
	}

	public void setCodigo_venta_vendedor_old(String codigo_venta_vendedor_old) {
		this.codigo_venta_vendedor_old = codigo_venta_vendedor_old;
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

	public int getFkcodigo_usuario_new() {
		return fkcodigo_usuario_new;
	}

	public void setFkcodigo_usuario_new(int fkcodigo_usuario_new) {
		this.fkcodigo_usuario_new = fkcodigo_usuario_new;
	}

	public int getFkcodigo_area_new() {
		return fkcodigo_area_new;
	}

	public void setFkcodigo_area_new(int fkcodigo_area_new) {
		this.fkcodigo_area_new = fkcodigo_area_new;
	}

	public String getCodigo_venta_vendedor_new() {
		return codigo_venta_vendedor_new;
	}

	public void setCodigo_venta_vendedor_new(String codigo_venta_vendedor_new) {
		this.codigo_venta_vendedor_new = codigo_venta_vendedor_new;
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
