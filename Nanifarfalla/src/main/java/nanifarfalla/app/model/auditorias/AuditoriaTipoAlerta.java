package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_tipoalerta")
public class AuditoriaTipoAlerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_tipoalerta;
	String usuario;
	Date fecha_cambio;
	String nombre_tipoalerta_old;
	Date version_old;
	String nombre_tipoalerta_new;
	Date version_new;

	public AuditoriaTipoAlerta() {

	}

	public int getCodigo_audi_tipoalerta() {
		return codigo_audi_tipoalerta;
	}

	public void setCodigo_audi_tipoalerta(int codigo_audi_tipoalerta) {
		this.codigo_audi_tipoalerta = codigo_audi_tipoalerta;
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

	public String getNombre_tipoalerta_old() {
		return nombre_tipoalerta_old;
	}

	public void setNombre_tipoalerta_old(String nombre_tipoalerta_old) {
		this.nombre_tipoalerta_old = nombre_tipoalerta_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_tipoalerta_new() {
		return nombre_tipoalerta_new;
	}

	public void setNombre_tipoalerta_new(String nombre_tipoalerta_new) {
		this.nombre_tipoalerta_new = nombre_tipoalerta_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
