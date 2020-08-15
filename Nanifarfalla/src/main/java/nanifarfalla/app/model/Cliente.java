package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_cliente;
	String razonsocial_cliente;
	String mensaje_cliente;

	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;

	@JoinColumn(name = "fkcodigo_regimencliente", referencedColumnName = "codigo_regimencliente")
	@ManyToOne
	RegimenCliente mRegimen_cliente;

	@JoinColumn(name = "fkcodigo_estadocliente", referencedColumnName = "codigo_estadocliente")
	@ManyToOne
	EstadoCliente mEstadoCliente;

	public EstadoCliente getmEstadoCliente() {
		return mEstadoCliente;
	}

	public void setmEstadoCliente(EstadoCliente mEstadoCliente) {
		this.mEstadoCliente = mEstadoCliente;
	}

	@OneToMany(mappedBy = "mCliente")
	private Collection<ClienteTienePedido> cliente_tiene_pedido = new ArrayList<>();

	// int fkcodigo_usuario;
	// int fkcodigo_regimencliente;
	// int fkcodigo_estadocliente;
	Double latitud_cliente;
	Double longitud_cliente;
	String type_cliente;
	String foto_ruta;
	String ruc_cliente;
	String dni_cliente;
	Date fecha_empadronamiento_cliente;
	String claveApi;
	Date version;

	public Cliente() {

	}

	public int getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getRazonsocial_cliente() {
		return razonsocial_cliente;
	}

	public void setRazonsocial_cliente(String razonsocial_cliente) {
		this.razonsocial_cliente = razonsocial_cliente;
	}

	public String getMensaje_cliente() {
		return mensaje_cliente;
	}

	public void setMensaje_cliente(String mensaje_cliente) {
		this.mensaje_cliente = mensaje_cliente;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
	}

	public RegimenCliente getmRegimen_cliente() {
		return mRegimen_cliente;
	}

	public void setmRegimen_cliente(RegimenCliente mRegimen_cliente) {
		this.mRegimen_cliente = mRegimen_cliente;
	}

	public Collection<ClienteTienePedido> getCliente_tiene_pedido() {
		return cliente_tiene_pedido;
	}

	public void setCliente_tiene_pedido(Collection<ClienteTienePedido> cliente_tiene_pedido) {
		this.cliente_tiene_pedido = cliente_tiene_pedido;
	}

	public Double getLatitud_cliente() {
		return latitud_cliente;
	}

	public void setLatitud_cliente(Double latitud_cliente) {
		this.latitud_cliente = latitud_cliente;
	}

	public Double getLongitud_cliente() {
		return longitud_cliente;
	}

	public void setLongitud_cliente(Double longitud_cliente) {
		this.longitud_cliente = longitud_cliente;
	}

	public String getType_cliente() {
		return type_cliente;
	}

	public void setType_cliente(String type_cliente) {
		this.type_cliente = type_cliente;
	}

	public String getFoto_ruta() {
		return foto_ruta;
	}

	public void setFoto_ruta(String foto_ruta) {
		this.foto_ruta = foto_ruta;
	}

	public String getRuc_cliente() {
		return ruc_cliente;
	}

	public void setRuc_cliente(String ruc_cliente) {
		this.ruc_cliente = ruc_cliente;
	}

	public String getDni_cliente() {
		return dni_cliente;
	}

	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	public Date getFecha_empadronamiento_cliente() {
		return fecha_empadronamiento_cliente;
	}

	public void setFecha_empadronamiento_cliente(Date fecha_empadronamiento_cliente) {
		this.fecha_empadronamiento_cliente = fecha_empadronamiento_cliente;
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
