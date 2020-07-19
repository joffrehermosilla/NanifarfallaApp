package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Usuario {
	private int codigo_usuario;
	private String nombre_usuario;
	private String paterno_usuario;
	private String materno_usuario;
	private String foto_usuario;
	private String mensaje_usuario;
	private Date fechacreacion;

	public Collection<UserAnuncios> getUseranuncios() {
		return useranuncios;
	}

	public void setUseranuncios(Collection<UserAnuncios> useranuncios) {
		this.useranuncios = useranuncios;
	}

	@OneToMany(mappedBy = "mUsuario", fetch = FetchType.EAGER)
	private Collection<UserAnuncios> useranuncios = new ArrayList<>();

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
