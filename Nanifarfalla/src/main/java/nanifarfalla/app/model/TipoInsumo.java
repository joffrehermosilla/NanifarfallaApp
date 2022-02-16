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
@Table(name = "tipo_insumo")
public class TipoInsumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipoinsumo;
	String nombre_tipo_insumo;
	String claveApi;
	Date version;
	
	

	@OneToMany(mappedBy = "mTipoinsumo", fetch = FetchType.EAGER)
	private transient Collection<Insumo> insumos = new ArrayList<>();
	
	
	
	public Collection<Insumo> getInsumos() {
		return insumos;
	}
	public void setInsumos(Collection<Insumo> insumos) {
		this.insumos = insumos;
	}
	public TipoInsumo() {
	
	}
	public int getCodigo_tipoinsumo() {
		return codigo_tipoinsumo;
	}
	public void setCodigo_tipoinsumo(int codigo_tipoinsumo) {
		this.codigo_tipoinsumo = codigo_tipoinsumo;
	}
	public String getNombre_tipo_insumo() {
		return nombre_tipo_insumo;
	}
	public void setNombre_tipo_insumo(String nombre_tipo_insumo) {
		this.nombre_tipo_insumo = nombre_tipo_insumo;
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
