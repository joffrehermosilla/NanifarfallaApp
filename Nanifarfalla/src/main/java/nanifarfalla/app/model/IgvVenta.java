package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "igv_venta")
public class IgvVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_igv_venta;
	@JoinColumn(name = "fkcodigo_tipo_impuesto", referencedColumnName = "codigo_tipo_impuesto")
	@ManyToOne
	TipoImpuesto mTipoImpuesto;

	// int fkcodigo_tipo_impuesto;
	Double porcentaje_igv_venta;
	String claveApi;
	Date version;

	public IgvVenta() {

	}

	public int getCodigo_igv_venta() {
		return codigo_igv_venta;
	}

	public void setCodigo_igv_venta(int codigo_igv_venta) {
		this.codigo_igv_venta = codigo_igv_venta;
	}

	public TipoImpuesto getmTipoImpuesto() {
		return mTipoImpuesto;
	}

	public void setmTipoImpuesto(TipoImpuesto mTipoImpuesto) {
		this.mTipoImpuesto = mTipoImpuesto;
	}

	public Double getPorcentaje_igv_venta() {
		return porcentaje_igv_venta;
	}

	public void setPorcentaje_igv_venta(Double porcentaje_igv_venta) {
		this.porcentaje_igv_venta = porcentaje_igv_venta;
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
