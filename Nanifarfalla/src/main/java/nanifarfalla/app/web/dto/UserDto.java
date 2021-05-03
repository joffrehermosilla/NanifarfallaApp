package nanifarfalla.app.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import nanifarfalla.app.model.Area;
import nanifarfalla.app.model.Cliente;
import nanifarfalla.app.model.Contrato;
import nanifarfalla.app.model.Distrito;
import nanifarfalla.app.model.EstadoCliente;
import nanifarfalla.app.model.EstadoContrato;
import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.model.RegimenCliente;
import nanifarfalla.app.model.TipoUsuario;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.model.Vendedor;
import nanifarfalla.app.validation.PasswordMatches;
import nanifarfalla.app.validation.ValidEmail;
import nanifarfalla.app.validation.ValidPassword;

@PasswordMatches
public class UserDto {
	private int codigo_usuario;
	
	@NotNull
	@Size(min = 1, message = "{Size.userDto.firstName}")
	private String nombre_usuario;

	@NotNull
	@Size(min = 1, message = "{Size.userDto.lastName}")
	private String apellido_usuario;

	@ValidPassword
	private String password_usuario;

	@NotNull
	@Size(min = 1)
	private String matchingPassword;

	@ValidEmail
	@NotNull
	@NotBlank(message = "Enter your email")
	@Size(min = 1, message = "{Size.userDto.email}")
	@Email(message = "Enter a valid email address")
	private String email;

	private boolean isUsing2FA;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	private Distrito distrito;
	private EstadoUsuario estadousuario;
	private TipoUsuario tipousuario;

	private Cliente cliente;
	private RegimenCliente regimencliente;
	private EstadoCliente estadocliente;
	private Contrato contrato;
	private EstadoContrato estadocontrato;
	private Area area;
	private Vendedor vendedor;

	private Usuario usuario;
	
	
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public RegimenCliente getRegimencliente() {
		return regimencliente;
	}

	public void setRegimencliente(RegimenCliente regimencliente) {
		this.regimencliente = regimencliente;
	}

	public EstadoCliente getEstadocliente() {
		return estadocliente;
	}

	public void setEstadocliente(EstadoCliente estadocliente) {
		this.estadocliente = estadocliente;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public EstadoContrato getEstadocontrato() {
		return estadocontrato;
	}

	public void setEstadocontrato(EstadoContrato estadocontrato) {
		this.estadocontrato = estadocontrato;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public EstadoUsuario getEstadousuario() {
		return estadousuario;
	}

	public void setEstadousuario(EstadoUsuario estadousuario) {
		this.estadousuario = estadousuario;
	}

	public TipoUsuario getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	private int district;

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	private Integer role;

	public Integer getRole() {
		return role;
	}

	public void setRole(final Integer role) {
		this.role = role;
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

	public String getPassword_usuario() {
		return password_usuario;
	}

	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(final String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public boolean isUsing2FA() {
		return isUsing2FA;
	}

	public void setUsing2FA(boolean isUsing2FA) {
		this.isUsing2FA = isUsing2FA;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("UserDto [firstName=").append(nombre_usuario).append(", lastName=").append(apellido_usuario)
				.append(", password=").append(password_usuario).append(", matchingPassword=").append(matchingPassword)
				.append(", email=").append(email).append(", isUsing2FA=").append(isUsing2FA).append(", role=")
				.append(role).append("]");
		return builder.toString();
	}

}