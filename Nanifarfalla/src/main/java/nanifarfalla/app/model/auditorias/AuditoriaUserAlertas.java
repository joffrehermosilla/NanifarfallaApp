package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aud_user_alertas")
public class AuditoriaUserAlertas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_user_alerta;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_alerta_old;
	int fkcodigo_usuario_old;
	Double precio_old;
	Date fecha_inicio_old;
	Date fecha_fin_old;
	Date version_old;
	int fkcodigo_alerta_new;
	int fkcodigo_usuario_new;
	Double precio_new;
	Date fecha_inicio_new;
	Date fecha_fin_new;
	Date version_new;

	public AuditoriaUserAlertas() {

	}

	public int getCodigo_audi_user_alerta() {
		return codigo_audi_user_alerta;
	}

	public void setCodigo_audi_user_alerta(int codigo_audi_user_alerta) {
		this.codigo_audi_user_alerta = codigo_audi_user_alerta;
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

	public int getFkcodigo_alerta_old() {
		return fkcodigo_alerta_old;
	}

	public void setFkcodigo_alerta_old(int fkcodigo_alerta_old) {
		this.fkcodigo_alerta_old = fkcodigo_alerta_old;
	}

	public int getFkcodigo_usuario_old() {
		return fkcodigo_usuario_old;
	}

	public void setFkcodigo_usuario_old(int fkcodigo_usuario_old) {
		this.fkcodigo_usuario_old = fkcodigo_usuario_old;
	}

	public Double getPrecio_old() {
		return precio_old;
	}

	public void setPrecio_old(Double precio_old) {
		this.precio_old = precio_old;
	}

	public Date getFecha_inicio_old() {
		return fecha_inicio_old;
	}

	public void setFecha_inicio_old(Date fecha_inicio_old) {
		this.fecha_inicio_old = fecha_inicio_old;
	}

	public Date getFecha_fin_old() {
		return fecha_fin_old;
	}

	public void setFecha_fin_old(Date fecha_fin_old) {
		this.fecha_fin_old = fecha_fin_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_alerta_new() {
		return fkcodigo_alerta_new;
	}

	public void setFkcodigo_alerta_new(int fkcodigo_alerta_new) {
		this.fkcodigo_alerta_new = fkcodigo_alerta_new;
	}

	public int getFkcodigo_usuario_new() {
		return fkcodigo_usuario_new;
	}

	public void setFkcodigo_usuario_new(int fkcodigo_usuario_new) {
		this.fkcodigo_usuario_new = fkcodigo_usuario_new;
	}

	public Double getPrecio_new() {
		return precio_new;
	}

	public void setPrecio_new(Double precio_new) {
		this.precio_new = precio_new;
	}

	public Date getFecha_inicio_new() {
		return fecha_inicio_new;
	}

	public void setFecha_inicio_new(Date fecha_inicio_new) {
		this.fecha_inicio_new = fecha_inicio_new;
	}

	public Date getFecha_fin_new() {
		return fecha_fin_new;
	}

	public void setFecha_fin_new(Date fecha_fin_new) {
		this.fecha_fin_new = fecha_fin_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
