package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_tipousuario")
public class AuditoriaTipoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_tipousuario;
	String usuario;
	Date fecha_cambio;
	String nombre_tipousuario_old;
	Date version_old;
	String nombre_tipousuario_new;
	Date version_new;

	public AuditoriaTipoUsuario() {

	}

	public int getCodigo_audi_tipousuario() {
		return codigo_audi_tipousuario;
	}

	public void setCodigo_audi_tipousuario(int codigo_audi_tipousuario) {
		this.codigo_audi_tipousuario = codigo_audi_tipousuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_cambio() {
		return fecha_cambio;
	}

	public void setFecha_cambio(Date fecha_cambio) {
		this.fecha_cambio = fecha_cambio;
	}

	public String getNombre_tipousuario_old() {
		return nombre_tipousuario_old;
	}

	public void setNombre_tipousuario_old(String nombre_tipousuario_old) {
		this.nombre_tipousuario_old = nombre_tipousuario_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_tipousuario_new() {
		return nombre_tipousuario_new;
	}

	public void setNombre_tipousuario_new(String nombre_tipousuario_new) {
		this.nombre_tipousuario_new = nombre_tipousuario_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
