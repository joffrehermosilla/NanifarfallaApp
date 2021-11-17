package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.jboss.aerogear.security.otp.api.Base32;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Entity
@Table(name = "usuario")
public class Usuario {


	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_usuario;
	private String nombre_usuario;
	private String apellido_usuario;
	private String foto_usuario;
	private String mensaje_usuario;
	Date version;
	Date fecha_nacimiento_usuario;
	String direccion_usuario;
	String nombre_logeo_usuario;
	String genero;
	@Column(length = 60)
	String password_usuario;
	private String email;
	String ruta_foto;
	private boolean enabled;
	private boolean isUsing2FA;
	private String secret;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario"), inverseJoinColumns = @JoinColumn(name = "fkcodigo_role", referencedColumnName = "codigo_role"))
	private Collection<Role> roles;
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

	@OneToMany(mappedBy = "mUsuario")
	private Collection<VerificationToken> verificationToken = new ArrayList<>();

	@OneToMany(mappedBy = "mUsuario")
	private Collection<Contrato> contratos = new ArrayList<>();

	@OneToMany(mappedBy = "mUsuario")
	private Collection<UserAlerta> useralertas = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private Collection<UserLocation> userlocation = new ArrayList<>();
	
	

	public Collection<UserLocation> getUserlocation() {
		return userlocation;
	}

	public void setUserlocation(Collection<UserLocation> userlocation) {
		this.userlocation = userlocation;
	}

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

	public String getGenero() {
		return genero;
	}

	public Usuario(int codigo_usuario) {

		this.codigo_usuario = codigo_usuario;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Collection<UserAlerta> getUseralertas() {
		return useralertas;
	}

	public void setUseralertas(Collection<UserAlerta> useralertas) {
		this.useralertas = useralertas;
	}

	public Collection<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Collection<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Usuario() {
		super();
		this.secret = Base32.random();
		this.enabled = false;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public boolean isUsing2FA() {
		return isUsing2FA;
	}

	public void setUsing2FA(boolean isUsing2FA) {
		this.isUsing2FA = isUsing2FA;
	}

	public Collection<VerificationToken> getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(Collection<VerificationToken> verificationToken) {
		this.verificationToken = verificationToken;
	}

	public Date getFecha_nacimiento_usuario() {
		return fecha_nacimiento_usuario;
	}

	public void setFecha_nacimiento_usuario(Date fecha_nacimiento_usuario) {
		this.fecha_nacimiento_usuario = fecha_nacimiento_usuario;
	}

	public String getDireccion_usuario() {
		return direccion_usuario;
	}

	public void setDireccion_usuario(String direccion_usuario) {
		this.direccion_usuario = direccion_usuario;
	}

	public String getNombre_logeo_usuario() {
		return nombre_logeo_usuario;
	}

	public void setNombre_logeo_usuario(String nombre_logeo_usuario) {
		this.nombre_logeo_usuario = nombre_logeo_usuario;
	}

	public String getPassword_usuario() {
		return password_usuario;
	}

	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuta_foto() {
		return ruta_foto;
	}

	public void setRuta_foto(String ruta_foto) {
		this.ruta_foto = ruta_foto;
	}

	public Distrito getmDistrito() {
		return mDistrito;
	}

	public void setmDistrito(Distrito mDistrito) {
		this.mDistrito = mDistrito;
	}

	public TipoUsuario getmTipoUsuario() {
		return mTipoUsuario;
	}

	public void setmTipoUsuario(TipoUsuario mTipoUsuario) {
		this.mTipoUsuario = mTipoUsuario;
	}

	public EstadoUsuario getmEstadoUsuario() {
		return mEstadoUsuario;
	}

	public void setmEstadoUsuario(EstadoUsuario mEstadoUsuario) {
		this.mEstadoUsuario = mEstadoUsuario;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

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

	public String getApellido_usuario() {
		return apellido_usuario;
	}

	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}

	public boolean isEnabled() {
		return enabled;
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

	public boolean isEnable() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((getEmail() == null) ? 0 : getEmail().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Usuario user = (Usuario) obj;
		if (!getEmail().equals(user.getEmail())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Usuario [codigo_usuario=").append(codigo_usuario).append(", nombre_usuario=")
				.append(nombre_usuario).append(", apellido_usuario=").append(apellido_usuario)
				.append(", email_usuario=").append(email).append(", password_usuario=").append(password_usuario)
				.append(", enabled=").append(enabled).append(", isUsing2FA2=").append(isUsing2FA).append(", secret=")
				.append(secret).append(", roles=").append(roles).append("]");
		return builder.toString();
	}

	public Collection<? extends GrantedAuthority> getAuthoritiesz(final Collection<Role> roles) {

		return getGrantedAuthorities(getPrivileges(roles));
	}

	private final List<String> getPrivileges(final Collection<Role> roles) {
		final List<String> privileges = new ArrayList<String>();
		final List<Privilege> collection = new ArrayList<Privilege>();
		for (final Role role : roles) {
			collection.addAll(role.getPrivileges());
		}
		for (final Privilege item : collection) {
			privileges.add(item.getName());
		}

		return privileges;
	}

	private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (final String privilege : privileges) {
			authorities.add(new SimpleGrantedAuthority(privilege));
		}
		return authorities;
	}

	
	public Usuario(String nombre_usuario, String apellido_usuario, String password_usuario, String email,
			boolean enabled, Collection<Role> roles) {
	
		this.nombre_usuario = nombre_usuario;
		this.apellido_usuario = apellido_usuario;
		this.password_usuario = password_usuario;
		this.email = email;
		this.enabled = enabled;
		this.roles=roles;
		
	}

	
	
	
}
