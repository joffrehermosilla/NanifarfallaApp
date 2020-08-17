package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_vendedor;
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;
	// int fkcodigo_usuario;
	@JoinColumn(name = "fkcodigo_area", referencedColumnName = "codigo_area")
	@ManyToOne
	Area mArea;
	// int fkcodigo_area;
	String codigo_venta_vendedor;
	String claveApi;
	Date version;

	@OneToMany(mappedBy = "mVendedor")
	private Collection<ClienteTienePedido> clientetienepedidos = new ArrayList<>();

	public int getCodigo_vendedor() {
		return codigo_vendedor;
	}

	public void setCodigo_vendedor(int codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
	}

	public Area getmArea() {
		return mArea;
	}

	public void setmArea(Area mArea) {
		this.mArea = mArea;
	}

	public String getCodigo_venta_vendedor() {
		return codigo_venta_vendedor;
	}

	public void setCodigo_venta_vendedor(String codigo_venta_vendedor) {
		this.codigo_venta_vendedor = codigo_venta_vendedor;
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

	public Collection<ClienteTienePedido> getClientetienepedidos() {
		return clientetienepedidos;
	}

	public void setClientetienepedidos(Collection<ClienteTienePedido> clientetienepedidos) {
		this.clientetienepedidos = clientetienepedidos;
	}

}
