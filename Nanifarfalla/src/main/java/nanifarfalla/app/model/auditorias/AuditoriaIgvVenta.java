package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_igv_venta")
public class AuditoriaIgvVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_igv_venta;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_tipo_impuesto_old;
	Double porcentaje_igv_venta_old;
	String claveApi_old;
	Date version_old;
	int fkcodigo_tipo_impuesto_new;
	Double porcentaje_igv_venta_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaIgvVenta() {

	}

	public int getCodigo_audi_igv_venta() {
		return codigo_audi_igv_venta;
	}

	public void setCodigo_audi_igv_venta(int codigo_audi_igv_venta) {
		this.codigo_audi_igv_venta = codigo_audi_igv_venta;
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

	public int getFkcodigo_tipo_impuesto_old() {
		return fkcodigo_tipo_impuesto_old;
	}

	public void setFkcodigo_tipo_impuesto_old(int fkcodigo_tipo_impuesto_old) {
		this.fkcodigo_tipo_impuesto_old = fkcodigo_tipo_impuesto_old;
	}

	public Double getPorcentaje_igv_venta_old() {
		return porcentaje_igv_venta_old;
	}

	public void setPorcentaje_igv_venta_old(Double porcentaje_igv_venta_old) {
		this.porcentaje_igv_venta_old = porcentaje_igv_venta_old;
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

	public int getFkcodigo_tipo_impuesto_new() {
		return fkcodigo_tipo_impuesto_new;
	}

	public void setFkcodigo_tipo_impuesto_new(int fkcodigo_tipo_impuesto_new) {
		this.fkcodigo_tipo_impuesto_new = fkcodigo_tipo_impuesto_new;
	}

	public Double getPorcentaje_igv_venta_new() {
		return porcentaje_igv_venta_new;
	}

	public void setPorcentaje_igv_venta_new(Double porcentaje_igv_venta_new) {
		this.porcentaje_igv_venta_new = porcentaje_igv_venta_new;
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
