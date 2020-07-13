package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_distrito")
public class AuditoriaDistrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_distrito;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_ciudad_old;
	String nombre_distrito_old;
	Date version_old;
	int fkcodigo_ciudad_new;
	String nombre_distrito_new;
	Date version_new;

	public AuditoriaDistrito() {

	}

	public int getCodigo_audi_distrito() {
		return codigo_audi_distrito;
	}

	public void setCodigo_audi_distrito(int codigo_audi_distrito) {
		this.codigo_audi_distrito = codigo_audi_distrito;
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

	public int getFkcodigo_ciudad_old() {
		return fkcodigo_ciudad_old;
	}

	public void setFkcodigo_ciudad_old(int fkcodigo_ciudad_old) {
		this.fkcodigo_ciudad_old = fkcodigo_ciudad_old;
	}

	public String getNombre_distrito_old() {
		return nombre_distrito_old;
	}

	public void setNombre_distrito_old(String nombre_distrito_old) {
		this.nombre_distrito_old = nombre_distrito_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_ciudad_new() {
		return fkcodigo_ciudad_new;
	}

	public void setFkcodigo_ciudad_new(int fkcodigo_ciudad_new) {
		this.fkcodigo_ciudad_new = fkcodigo_ciudad_new;
	}

	public String getNombre_distrito_new() {
		return nombre_distrito_new;
	}

	public void setNombre_distrito_new(String nombre_distrito_new) {
		this.nombre_distrito_new = nombre_distrito_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
