package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_alertas")
public class AuditoriaAlerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_alerta;
	String usuario;
	Date fecha_cambio;
	String mensaje_alerta_old;
	Double precio_old;
	int fkcodigo_tipoalerta_old;
	Date version_old;
	String mensaje_alerta_new;
	Double precio_new;
	int fkcodigo_tipoalerta_new;
	Date version_new;

	public AuditoriaAlerta() {

	}

	public int getCodigo_audi_alerta() {
		return codigo_audi_alerta;
	}

	public void setCodigo_audi_alerta(int codigo_audi_alerta) {
		this.codigo_audi_alerta = codigo_audi_alerta;
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

	public String getMensaje_alerta_old() {
		return mensaje_alerta_old;
	}

	public void setMensaje_alerta_old(String mensaje_alerta_old) {
		this.mensaje_alerta_old = mensaje_alerta_old;
	}

	public Double getPrecio_old() {
		return precio_old;
	}

	public void setPrecio_old(Double precio_old) {
		this.precio_old = precio_old;
	}

	public int getFkcodigo_tipoalerta_old() {
		return fkcodigo_tipoalerta_old;
	}

	public void setFkcodigo_tipoalerta_old(int fkcodigo_tipoalerta_old) {
		this.fkcodigo_tipoalerta_old = fkcodigo_tipoalerta_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getMensaje_alerta_new() {
		return mensaje_alerta_new;
	}

	public void setMensaje_alerta_new(String mensaje_alerta_new) {
		this.mensaje_alerta_new = mensaje_alerta_new;
	}

	public Double getPrecio_new() {
		return precio_new;
	}

	public void setPrecio_new(Double precio_new) {
		this.precio_new = precio_new;
	}

	public int getFkcodigo_tipoalerta_new() {
		return fkcodigo_tipoalerta_new;
	}

	public void setFkcodigo_tipoalerta_new(int fkcodigo_tipoalerta_new) {
		this.fkcodigo_tipoalerta_new = fkcodigo_tipoalerta_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
