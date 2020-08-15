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
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_usuario;
	private String nombre_usuario;
	private String paterno_usuario;
	private String materno_usuario;
	private String foto_usuario;
	private String mensaje_usuario;
	private Date fechacreacion;

	@OneToMany(mappedBy = "mUsuario")
	private Collection<UserAnuncios> useranuncios = new ArrayList<>();

	@OneToMany(mappedBy = "mUsuario")
	private Collection<PasswordRessetToken> passwordResetTokens = new ArrayList<>();

	@OneToMany(mappedBy = "mUsuario")
	private Collection<ClienteTienePedido> clientetienepedidos = new ArrayList<>();

	@OneToMany(mappedBy = "mUsuario")
	private Collection<Vendedor> vendedores = new ArrayList<>();

	@OneToMany(mappedBy = "mUsuario")
	private Collection<UserRoles> userRoles = new ArrayList<>();

	Date fecha_nacimiento_usuario;
	String direccion_usuario;
	String nombre_logeo_usuario;
	String password_usuario;
	String email_usuario;
	String ruta_foto;
	int enabled;
	int isUsing2FA;

	@JoinColumn(name = "fkcodigo_distrito", referencedColumnName = "codigo_distrito")
	@ManyToOne
	Distrito mDistrito;
//fkcodigo_distrito	
	@JoinColumn(name = "fkcodigo_tipousuario", referencedColumnName = "codigo_tipousuario")
	@ManyToOne
	TipoUsuario mTipoUsuario;
//fkcodigo_tipousuario	
	@JoinColumn(name = "fkcodigo_estadousuario", referencedColumnName = "codigo_estadousuario")
	@ManyToOne
	EstadoUsuario mEstadoUsuario;

//fkcodigo_estadousuario	
	Date version;

	public Collection<Vendedor> getVendedores() {
		return vendedores;
	}

	public Collection<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Collection<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public void setVendedores(Collection<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public Collection<ClienteTienePedido> getClientetienepedidos() {
		return clientetienepedidos;
	}

	public void setClientetienepedidos(Collection<ClienteTienePedido> clientetienepedidos) {
		this.clientetienepedidos = clientetienepedidos;
	}

	public Collection<UserAnuncios> getUseranuncios() {
		return useranuncios;
	}

	public void setUseranuncios(Collection<UserAnuncios> useranuncios) {
		this.useranuncios = useranuncios;
	}

	public Collection<PasswordRessetToken> getPasswordResetTokens() {
		return passwordResetTokens;
	}

	public void setPasswordResetTokens(Collection<PasswordRessetToken> passwordResetTokens) {
		this.passwordResetTokens = passwordResetTokens;
	}

	@Override
	public String toString() {
		return "Usuariox [codigo_usuario=" + codigo_usuario + ", nombre_usuario=" + nombre_usuario
				+ ", paterno_usuario=" + paterno_usuario + ", materno_usuario=" + materno_usuario + ", foto_usuario="
				+ foto_usuario + ", mensaje_usuario=" + mensaje_usuario + ", fechacreacion=" + fechacreacion + "]";
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPaterno_usuario() {
		return paterno_usuario;
	}

	public void setPaterno_usuario(String paterno_usuario) {
		this.paterno_usuario = paterno_usuario;
	}

	public String getMaterno_usuario() {
		return materno_usuario;
	}

	public void setMaterno_usuario(String materno_usuario) {
		this.materno_usuario = materno_usuario;
	}

	public String getFoto_usuario() {
		return foto_usuario;
	}

	public void setFoto_usuario(String foto_usuario) {
		this.foto_usuario = foto_usuario;
	}

	public String getMensaje_usuario() {
		return mensaje_usuario;
	}

	public void setMensaje_usuario(String mensaje_usuario) {
		this.mensaje_usuario = mensaje_usuario;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

}
