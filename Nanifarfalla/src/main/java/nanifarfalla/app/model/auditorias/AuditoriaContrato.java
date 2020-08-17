package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_contrato")
public class AuditoriaContrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_contrato;

	String usuario;
	Date fecha_cambio;
	String descripcion_old;
	Double monto_old;
	Date fecha_inicio_old;
	Date fecha_fin_old;
	int fkcodigo_estadoContrato_old;
	int fkcodigo_usuario_old;
	int fkcodigo_cliente_old;
	int fkcodigo_user_alerta_old;
	int fkcodigo_user_anuncio_old;
	int fkcodigo_pedido_web_old;
	int fkcodigo_catalogo_old;
	Date version_old;
	String descripcion_new;
	Double monto_new;
	Date fecha_inicio_new;
	Date fecha_fin_new;
	int fkcodigo_estadoContrato_new;
	int fkcodigo_usuario_new;
	int fkcodigo_cliente_new;
	int fkcodigo_user_alerta_new;
	int fkcodigo_user_anuncio_new;
	int fkcodigo_pedido_web_new;
	int fkcodigo_catalogo_new;
	Date version_new;

	public AuditoriaContrato() {

	}

	public int getCodigo_audi_contrato() {
		return codigo_audi_contrato;
	}

	public void setCodigo_audi_contrato(int codigo_audi_contrato) {
		this.codigo_audi_contrato = codigo_audi_contrato;
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

	public String getDescripcion_old() {
		return descripcion_old;
	}

	public void setDescripcion_old(String descripcion_old) {
		this.descripcion_old = descripcion_old;
	}

	public Double getMonto_old() {
		return monto_old;
	}

	public void setMonto_old(Double monto_old) {
		this.monto_old = monto_old;
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

	public int getFkcodigo_estadoContrato_old() {
		return fkcodigo_estadoContrato_old;
	}

	public void setFkcodigo_estadoContrato_old(int fkcodigo_estadoContrato_old) {
		this.fkcodigo_estadoContrato_old = fkcodigo_estadoContrato_old;
	}

	public int getFkcodigo_usuario_old() {
		return fkcodigo_usuario_old;
	}

	public void setFkcodigo_usuario_old(int fkcodigo_usuario_old) {
		this.fkcodigo_usuario_old = fkcodigo_usuario_old;
	}

	public int getFkcodigo_cliente_old() {
		return fkcodigo_cliente_old;
	}

	public void setFkcodigo_cliente_old(int fkcodigo_cliente_old) {
		this.fkcodigo_cliente_old = fkcodigo_cliente_old;
	}

	public int getFkcodigo_user_alerta_old() {
		return fkcodigo_user_alerta_old;
	}

	public void setFkcodigo_user_alerta_old(int fkcodigo_user_alerta_old) {
		this.fkcodigo_user_alerta_old = fkcodigo_user_alerta_old;
	}

	public int getFkcodigo_user_anuncio_old() {
		return fkcodigo_user_anuncio_old;
	}

	public void setFkcodigo_user_anuncio_old(int fkcodigo_user_anuncio_old) {
		this.fkcodigo_user_anuncio_old = fkcodigo_user_anuncio_old;
	}

	public int getFkcodigo_pedido_web_old() {
		return fkcodigo_pedido_web_old;
	}

	public void setFkcodigo_pedido_web_old(int fkcodigo_pedido_web_old) {
		this.fkcodigo_pedido_web_old = fkcodigo_pedido_web_old;
	}

	public int getFkcodigo_catalogo_old() {
		return fkcodigo_catalogo_old;
	}

	public void setFkcodigo_catalogo_old(int fkcodigo_catalogo_old) {
		this.fkcodigo_catalogo_old = fkcodigo_catalogo_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getDescripcion_new() {
		return descripcion_new;
	}

	public void setDescripcion_new(String descripcion_new) {
		this.descripcion_new = descripcion_new;
	}

	public Double getMonto_new() {
		return monto_new;
	}

	public void setMonto_new(Double monto_new) {
		this.monto_new = monto_new;
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

	public int getFkcodigo_estadoContrato_new() {
		return fkcodigo_estadoContrato_new;
	}

	public void setFkcodigo_estadoContrato_new(int fkcodigo_estadoContrato_new) {
		this.fkcodigo_estadoContrato_new = fkcodigo_estadoContrato_new;
	}

	public int getFkcodigo_usuario_new() {
		return fkcodigo_usuario_new;
	}

	public void setFkcodigo_usuario_new(int fkcodigo_usuario_new) {
		this.fkcodigo_usuario_new = fkcodigo_usuario_new;
	}

	public int getFkcodigo_cliente_new() {
		return fkcodigo_cliente_new;
	}

	public void setFkcodigo_cliente_new(int fkcodigo_cliente_new) {
		this.fkcodigo_cliente_new = fkcodigo_cliente_new;
	}

	public int getFkcodigo_user_alerta_new() {
		return fkcodigo_user_alerta_new;
	}

	public void setFkcodigo_user_alerta_new(int fkcodigo_user_alerta_new) {
		this.fkcodigo_user_alerta_new = fkcodigo_user_alerta_new;
	}

	public int getFkcodigo_user_anuncio_new() {
		return fkcodigo_user_anuncio_new;
	}

	public void setFkcodigo_user_anuncio_new(int fkcodigo_user_anuncio_new) {
		this.fkcodigo_user_anuncio_new = fkcodigo_user_anuncio_new;
	}

	public int getFkcodigo_pedido_web_new() {
		return fkcodigo_pedido_web_new;
	}

	public void setFkcodigo_pedido_web_new(int fkcodigo_pedido_web_new) {
		this.fkcodigo_pedido_web_new = fkcodigo_pedido_web_new;
	}

	public int getFkcodigo_catalogo_new() {
		return fkcodigo_catalogo_new;
	}

	public void setFkcodigo_catalogo_new(int fkcodigo_catalogo_new) {
		this.fkcodigo_catalogo_new = fkcodigo_catalogo_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
