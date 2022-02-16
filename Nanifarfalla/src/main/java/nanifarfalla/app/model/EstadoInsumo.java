package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	
	
	@OneToMany(mappedBy = "mEstadoinsumo", fetch = FetchType.EAGER)
	private transient Collection<Insumo> insumos = new ArrayList<>();

	
	
	
	
	public Collection<Insumo> getInsumos() {
		return insumos;
	}
	public void setInsumos(Collection<Insumo> insumos) {
		this.insumos = insumos;
	}
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
