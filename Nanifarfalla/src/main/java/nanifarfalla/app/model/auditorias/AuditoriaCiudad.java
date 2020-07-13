package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_ciudad")
public class AuditoriaCiudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_ciudad;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_provincia_old;
	String nombre_ciudad_old;
	Date version_old;
	int fkcodigo_provincia_new;
	String nombre_ciudad_new;
	Date version_new;

	public AuditoriaCiudad() {

	}

	public int getCodigo_audi_ciudad() {
		return codigo_audi_ciudad;
	}

	public void setCodigo_audi_ciudad(int codigo_audi_ciudad) {
		this.codigo_audi_ciudad = codigo_audi_ciudad;
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

	public int getFkcodigo_provincia_old() {
		return fkcodigo_provincia_old;
	}

	public void setFkcodigo_provincia_old(int fkcodigo_provincia_old) {
		this.fkcodigo_provincia_old = fkcodigo_provincia_old;
	}

	public String getNombre_ciudad_old() {
		return nombre_ciudad_old;
	}

	public void setNombre_ciudad_old(String nombre_ciudad_old) {
		this.nombre_ciudad_old = nombre_ciudad_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_provincia_new() {
		return fkcodigo_provincia_new;
	}

	public void setFkcodigo_provincia_new(int fkcodigo_provincia_new) {
		this.fkcodigo_provincia_new = fkcodigo_provincia_new;
	}

	public String getNombre_ciudad_new() {
		return nombre_ciudad_new;
	}

	public void setNombre_ciudad_new(String nombre_ciudad_new) {
		this.nombre_ciudad_new = nombre_ciudad_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
