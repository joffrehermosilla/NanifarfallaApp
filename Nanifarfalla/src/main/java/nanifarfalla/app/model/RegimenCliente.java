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
@Table(name = "regimen_cliente")
public class RegimenCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_regimencliente;
	String nombre_regimencliente;

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	Date version;

	@OneToMany(mappedBy = "mRegimen_cliente", fetch = FetchType.EAGER)
	private transient Collection<Cliente> clientes = new ArrayList<>();

	public RegimenCliente() {

	}

	public int getCodigo_regimencliente() {
		return codigo_regimencliente;
	}

	public void setCodigo_regimencliente(int codigo_regimencliente) {
		this.codigo_regimencliente = codigo_regimencliente;
	}

	public String getNombre_regimencliente() {
		return nombre_regimencliente;
	}

	public void setNombre_regimencliente(String nombre_regimencliente) {
		this.nombre_regimencliente = nombre_regimencliente;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
