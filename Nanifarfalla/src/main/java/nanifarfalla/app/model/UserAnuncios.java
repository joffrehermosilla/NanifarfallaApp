package nanifarfalla.app.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_anuncios")
public class UserAnuncios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_user_anuncio;
	@JoinColumn(name = "fkcodigo_anuncio", referencedColumnName = "codigo_anuncio")
	@ManyToOne
	Anuncio mAnuncio;
	// int fkcodigo_anuncio;
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;
	// int fkcodigo_usuario;
	Date fecha_inicio;
	Date fecha_fin;
	Double precio;
	Date version;

	public UserAnuncios() {

	}

	public int getCodigo_user_anuncio() {
		return codigo_user_anuncio;
	}

	public void setCodigo_user_anuncio(int codigo_user_anuncio) {
		this.codigo_user_anuncio = codigo_user_anuncio;
	}

	public Anuncio getmAnuncio() {
		return mAnuncio;
	}

	public void setmAnuncio(Anuncio mAnuncio) {
		this.mAnuncio = mAnuncio;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
