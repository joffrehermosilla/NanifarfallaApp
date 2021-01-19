package nanifarfalla.app.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import nanifarfalla.app.model.Distrito;
import nanifarfalla.app.validation.PasswordMatches;
import nanifarfalla.app.validation.ValidEmail;
import nanifarfalla.app.validation.ValidPassword;

@PasswordMatches
public class UserDto {
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
	@Size(min = 1, message = "{Size.userDto.email}")
	private String email;

	private boolean isUsing2FA;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}
	private Distrito distrito;
	
	
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
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
