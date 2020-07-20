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
@Table(name = "tipo_impuesto")
public class TipoImpuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipo_impuesto;
	String nombre_tipo_impuesto;
	Double porcentaje_tipo_impuesto;
	String claveApi;
	Date version;

	@OneToMany(mappedBy = "mTipoImpuesto", fetch = FetchType.EAGER)
	private Collection<IgvVenta> igvventas = new ArrayList<>();

	public Collection<IgvVenta> getIgvventas() {
		return igvventas;
	}

	public void setIgvventas(Collection<IgvVenta> igvventas) {
		this.igvventas = igvventas;
	}

	public TipoImpuesto() {

	}

	public int getCodigo_tipo_impuesto() {
		return codigo_tipo_impuesto;
	}

	public void setCodigo_tipo_impuesto(int codigo_tipo_impuesto) {
		this.codigo_tipo_impuesto = codigo_tipo_impuesto;
	}

	public String getNombre_tipo_impuesto() {
		return nombre_tipo_impuesto;
	}

	public void setNombre_tipo_impuesto(String nombre_tipo_impuesto) {
		this.nombre_tipo_impuesto = nombre_tipo_impuesto;
	}

	public Double getPorcentaje_tipo_impuesto() {
		return porcentaje_tipo_impuesto;
	}

	public void setPorcentaje_tipo_impuesto(Double porcentaje_tipo_impuesto) {
		this.porcentaje_tipo_impuesto = porcentaje_tipo_impuesto;
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
