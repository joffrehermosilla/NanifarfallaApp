package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado_cliente")
public class EstadoCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadocliente;
	String nombre_estadocliente;
	String claveApi;
	Date version;

	@OneToMany(mappedBy = "mEstadoCliente")
	private Collection<Cliente> clientes = new ArrayList<>();

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public EstadoCliente() {

	}

	public int getCodigo_estadocliente() {
		return codigo_estadocliente;
	}

	public void setCodigo_estadocliente(int codigo_estadocliente) {
		this.codigo_estadocliente = codigo_estadocliente;
	}

	public String getNombre_estadocliente() {
		return nombre_estadocliente;
	}

	public void setNombre_estadocliente(String nombre_estadocliente) {
		this.nombre_estadocliente = nombre_estadocliente;
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
