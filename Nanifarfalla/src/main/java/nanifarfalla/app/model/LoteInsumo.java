package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lote_insumo")
public class LoteInsumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_loteinsumo;
	String nombre_lote_insumo;
	String claveApi;
	Date version;
	
	
	
	
	public LoteInsumo() {
	
	}
	public int getCodigo_loteinsumo() {
		return codigo_loteinsumo;
	}
	public void setCodigo_loteinsumo(int codigo_loteinsumo) {
		this.codigo_loteinsumo = codigo_loteinsumo;
	}
	public String getNombre_lote_insumo() {
		return nombre_lote_insumo;
	}
	public void setNombre_lote_insumo(String nombre_lote_insumo) {
		this.nombre_lote_insumo = nombre_lote_insumo;
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
