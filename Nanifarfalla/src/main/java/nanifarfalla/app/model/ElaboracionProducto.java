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
@Table(name = "elaboracion_producto")
public class ElaboracionProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_elaboracionproducto;
	String modelo_producto;
	String temporada_producto;
	String claveApi;
	Date version;
	

	@OneToMany(mappedBy = "mElaboracionProducto", fetch = FetchType.EAGER)
	private Collection<RecetaProductotieneInsumo> recetaproductostienenInsumo = new ArrayList<>();


	public Collection<RecetaProductotieneInsumo> getRecetaproductostienenInsumo() {
		return recetaproductostienenInsumo;
	}

	public void setRecetaproductostienenInsumo(Collection<RecetaProductotieneInsumo> recetaproductostienenInsumo) {
		this.recetaproductostienenInsumo = recetaproductostienenInsumo;
	}

	public ElaboracionProducto() {

	}

	public int getCodigo_elaboracionproducto() {
		return codigo_elaboracionproducto;
	}

	public void setCodigo_elaboracionproducto(int codigo_elaboracionproducto) {
		this.codigo_elaboracionproducto = codigo_elaboracionproducto;
	}

	public String getModelo_producto() {
		return modelo_producto;
	}

	public void setModelo_producto(String modelo_producto) {
		this.modelo_producto = modelo_producto;
	}

	public String getTemporada_producto() {
		return temporada_producto;
	}

	public void setTemporada_producto(String temporada_producto) {
		this.temporada_producto = temporada_producto;
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
