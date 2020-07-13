package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_provincia")
public class AuditoriaProvincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_provincia;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_pais_old;
	String nombre_provincia_old;
	Date version_old;
	int fkcodigo_pais_new;
	String nombre_provincia_new;
	Date version_new;

	public AuditoriaProvincia() {

	}

	public int getCodigo_audi_provincia() {
		return codigo_audi_provincia;
	}

	public void setCodigo_audi_provincia(int codigo_audi_provincia) {
		this.codigo_audi_provincia = codigo_audi_provincia;
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

	public int getFkcodigo_pais_old() {
		return fkcodigo_pais_old;
	}

	public void setFkcodigo_pais_old(int fkcodigo_pais_old) {
		this.fkcodigo_pais_old = fkcodigo_pais_old;
	}

	public String getNombre_provincia_old() {
		return nombre_provincia_old;
	}

	public void setNombre_provincia_old(String nombre_provincia_old) {
		this.nombre_provincia_old = nombre_provincia_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_pais_new() {
		return fkcodigo_pais_new;
	}

	public void setFkcodigo_pais_new(int fkcodigo_pais_new) {
		this.fkcodigo_pais_new = fkcodigo_pais_new;
	}

	public String getNombre_provincia_new() {
		return nombre_provincia_new;
	}

	public void setNombre_provincia_new(String nombre_provincia_new) {
		this.nombre_provincia_new = nombre_provincia_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
