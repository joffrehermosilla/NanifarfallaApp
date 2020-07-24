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
@Table(name = "passwordresettoken")
public class PasswordRessetToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_passwordresttoken;
	Date expiryDate;
	String token;
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;
	// int fkcodigo_usuario;
	Date version;

	public PasswordRessetToken() {

	}

	public int getCodigo_passwordresttoken() {
		return codigo_passwordresttoken;
	}

	public void setCodigo_passwordresttoken(int codigo_passwordresttoken) {
		this.codigo_passwordresttoken = codigo_passwordresttoken;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
