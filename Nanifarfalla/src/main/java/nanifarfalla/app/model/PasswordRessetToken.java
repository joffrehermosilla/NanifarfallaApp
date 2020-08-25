package nanifarfalla.app.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passwordresettoken")
public class PasswordRessetToken {

	private static final int EXPIRATION = 60 * 24;

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

	@OneToOne(targetEntity = Usuario.class)
	@JoinColumn(nullable = false, name = "fkcodigo_usuario", insertable = false, updatable = false)
	private Usuario user;

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}

	public PasswordRessetToken(final String token) {
		super();

		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public PasswordRessetToken(final String token, final Usuario user) {
		super();

		this.token = token;
		this.user = user;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

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

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

	public void updateToken(final String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		final PasswordRessetToken other = (PasswordRessetToken) obj;
		if (expiryDate == null) {
			if (other.expiryDate != null) {
				return false;
			}
		} else if (!expiryDate.equals(other.expiryDate)) {
			return false;
		}
		if (token == null) {
			if (other.token != null) {
				return false;
			}
		} else if (!token.equals(other.token)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Token [String=").append(token).append("]").append("[Expires").append(expiryDate).append("]");
		return builder.toString();
	}

}
