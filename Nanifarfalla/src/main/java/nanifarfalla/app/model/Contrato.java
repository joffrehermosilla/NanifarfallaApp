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
@Table(name = "contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_contrato;
	String descripcion;
	Double monto;
	Date fecha_inicio;
	Date fecha_fin;
	
	@JoinColumn(name = "fkcodigo_estadoContrato", referencedColumnName = "codigo_estadoContrato")
	@ManyToOne
	EstadoContrato mEstadoContrato;

	// fkcodigo_estadoContrato
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;

	// fkcodigo_usuario
	@JoinColumn(name = "fkcodigo_cliente", referencedColumnName = "codigo_cliente")
	@ManyToOne
	Cliente mCliente;

	// fkcodigo_cliente

	@JoinColumn(name = "fkcodigo_user_alerta", referencedColumnName = "codigo_user_alerta")
	@ManyToOne
	UserAlerta mUserAlerta;

	// fkcodigo_user_alerta
	@JoinColumn(name = "fkcodigo_user_anuncio", referencedColumnName = "codigo_user_anuncio")
	@ManyToOne
	UserAnuncios mUserAnuncios;

	// fkcodigo_user_anuncio
	@JoinColumn(name = "fkcodigo_pedido_web", referencedColumnName = "codigo_pedido_web")
	@ManyToOne
	ClienteTienePedido mClienteTienePedido;

	// fkcodigo_pedido_web

	@JoinColumn(name = "fkcodigo_catalogo", referencedColumnName = "codigo_catalogo")
	@ManyToOne
	Catalogo mCatalogo;

	// fkcodigo_catalogo
	Date version;

	public int getCodigo_contrato() {
		return codigo_contrato;
	}

	public void setCodigo_contrato(int codigo_contrato) {
		this.codigo_contrato = codigo_contrato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public EstadoContrato getmEstadoContrato() {
		return mEstadoContrato;
	}

	public void setmEstadoContrato(EstadoContrato mEstadoContrato) {
		this.mEstadoContrato = mEstadoContrato;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
	}

	public Cliente getmCliente() {
		return mCliente;
	}

	public void setmCliente(Cliente mCliente) {
		this.mCliente = mCliente;
	}

	public UserAlerta getmUserAlerta() {
		return mUserAlerta;
	}

	public void setmUserAlerta(UserAlerta mUserAlerta) {
		this.mUserAlerta = mUserAlerta;
	}

	public UserAnuncios getmUserAnuncios() {
		return mUserAnuncios;
	}

	public void setmUserAnuncios(UserAnuncios mUserAnuncios) {
		this.mUserAnuncios = mUserAnuncios;
	}

	public ClienteTienePedido getmClienteTienePedido() {
		return mClienteTienePedido;
	}

	public void setmClienteTienePedido(ClienteTienePedido mClienteTienePedido) {
		this.mClienteTienePedido = mClienteTienePedido;
	}

	public Catalogo getmCatalogo() {
		return mCatalogo;
	}

	public void setmCatalogo(Catalogo mCatalogo) {
		this.mCatalogo = mCatalogo;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	
	
	
}
