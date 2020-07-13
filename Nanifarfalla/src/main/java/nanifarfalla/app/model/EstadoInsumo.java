package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_insumo")
public class EstadoInsumo {

	public EstadoInsumo() {
	
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadoinsumo	;
	String nombre_estado_insumo;
	String claveApi;
	Date version;
	public int getCodigo_estadoinsumo() {
		return codigo_estadoinsumo;
	}
	public void setCodigo_estadoinsumo(int codigo_estadoinsumo) {
		this.codigo_estadoinsumo = codigo_estadoinsumo;
	}
	public String getNombre_estado_insumo() {
		return nombre_estado_insumo;
	}
	public void setNombre_estado_insumo(String nombre_estado_insumo) {
		this.nombre_estado_insumo = nombre_estado_insumo;
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
