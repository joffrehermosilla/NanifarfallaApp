package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_zona_tiene_distrito")
public class AuditoriaZonaTieneDistrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_zonta_tienedistrito;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_zona_old;
	int fkcodigo_distrito_old;
	String claveApi_old;
	Date version_old;
	int fkcodigo_zona_new;
	int fkcodigo_distrito_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaZonaTieneDistrito() {

	}

	public int getCodigo_zonta_tienedistrito() {
		return codigo_zonta_tienedistrito;
	}

	public void setCodigo_zonta_tienedistrito(int codigo_zonta_tienedistrito) {
		this.codigo_zonta_tienedistrito = codigo_zonta_tienedistrito;
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

	public int getFkcodigo_zona_old() {
		return fkcodigo_zona_old;
	}

	public void setFkcodigo_zona_old(int fkcodigo_zona_old) {
		this.fkcodigo_zona_old = fkcodigo_zona_old;
	}

	public int getFkcodigo_distrito_old() {
		return fkcodigo_distrito_old;
	}

	public void setFkcodigo_distrito_old(int fkcodigo_distrito_old) {
		this.fkcodigo_distrito_old = fkcodigo_distrito_old;
	}

	public String getClaveApi_old() {
		return claveApi_old;
	}

	public void setClaveApi_old(String claveApi_old) {
		this.claveApi_old = claveApi_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_zona_new() {
		return fkcodigo_zona_new;
	}

	public void setFkcodigo_zona_new(int fkcodigo_zona_new) {
		this.fkcodigo_zona_new = fkcodigo_zona_new;
	}

	public int getFkcodigo_distrito_new() {
		return fkcodigo_distrito_new;
	}

	public void setFkcodigo_distrito_new(int fkcodigo_distrito_new) {
		this.fkcodigo_distrito_new = fkcodigo_distrito_new;
	}

	public String getClaveApi_new() {
		return claveApi_new;
	}

	public void setClaveApi_new(String claveApi_new) {
		this.claveApi_new = claveApi_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
