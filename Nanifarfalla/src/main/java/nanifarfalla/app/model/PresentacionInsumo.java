package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "presentacion_insumo")
public class PresentacionInsumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_presentacioninsumo;
	String nombre_presentacion_insumo;
	String claveApi;
	Date version;

	public PresentacionInsumo() {

	}

	public int getCodigo_presentacioninsumo() {
		return codigo_presentacioninsumo;
	}

	public void setCodigo_presentacioninsumo(int codigo_presentacioninsumo) {
		this.codigo_presentacioninsumo = codigo_presentacioninsumo;
	}

	public String getNombre_presentacion_insumo() {
		return nombre_presentacion_insumo;
	}

	public void setNombre_presentacion_insumo(String nombre_presentacion_insumo) {
		this.nombre_presentacion_insumo = nombre_presentacion_insumo;
	}

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
