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
@Table(name = "estado_contrato")
public class EstadoContrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadoContrato;
	String descripcion;

	String claveApi;
	Date version;

	@OneToMany(mappedBy = "mEstadoContrato", fetch = FetchType.LAZY)
	private Collection<Contrato> contratos = new ArrayList<>();

	public EstadoContrato() {

		System.out.println("Inicio de las clase Estado Contrato");

	}

	public Collection<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Collection<Contrato> contratos) {
		this.contratos = contratos;
	}

	public int getCodigo_estadoContrato() {
		return codigo_estadoContrato;
	}

	public void setCodigo_estadoContrato(int codigo_estadoContrato) {
		this.codigo_estadoContrato = codigo_estadoContrato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
