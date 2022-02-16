package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_cliente_tiene_preferencia")
public class AuditoriaClienteTienePreferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_cliente_tiene_pedido;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_cliente_old;
	int fkcodigo_producto_old;
	Date fecha_voto_preferencia_old;
	int cantidad_puntos_old;
	Date version_old;
	int fkcodigo_cliente_new;
	int fkcodigo_producto_new;
	Date fecha_voto_preferencia_new;
	int cantidad_puntos_new;
	Date version_new;

	public AuditoriaClienteTienePreferencia() {

	}

	public int getCodigo_audi_cliente_tiene_pedido() {
		return codigo_audi_cliente_tiene_pedido;
	}

	public void setCodigo_audi_cliente_tiene_pedido(int codigo_audi_cliente_tiene_pedido) {
		this.codigo_audi_cliente_tiene_pedido = codigo_audi_cliente_tiene_pedido;
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

	public int getFkcodigo_cliente_old() {
		return fkcodigo_cliente_old;
	}

	public void setFkcodigo_cliente_old(int fkcodigo_cliente_old) {
		this.fkcodigo_cliente_old = fkcodigo_cliente_old;
	}

	public int getFkcodigo_producto_old() {
		return fkcodigo_producto_old;
	}

	public void setFkcodigo_producto_old(int fkcodigo_producto_old) {
		this.fkcodigo_producto_old = fkcodigo_producto_old;
	}

	public Date getFecha_voto_preferencia_old() {
		return fecha_voto_preferencia_old;
	}

	public void setFecha_voto_preferencia_old(Date fecha_voto_preferencia_old) {
		this.fecha_voto_preferencia_old = fecha_voto_preferencia_old;
	}

	public int getCantidad_puntos_old() {
		return cantidad_puntos_old;
	}

	public void setCantidad_puntos_old(int cantidad_puntos_old) {
		this.cantidad_puntos_old = cantidad_puntos_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_cliente_new() {
		return fkcodigo_cliente_new;
	}

	public void setFkcodigo_cliente_new(int fkcodigo_cliente_new) {
		this.fkcodigo_cliente_new = fkcodigo_cliente_new;
	}

	public int getFkcodigo_producto_new() {
		return fkcodigo_producto_new;
	}

	public void setFkcodigo_producto_new(int fkcodigo_producto_new) {
		this.fkcodigo_producto_new = fkcodigo_producto_new;
	}

	public Date getFecha_voto_preferencia_new() {
		return fecha_voto_preferencia_new;
	}

	public void setFecha_voto_auditoria_areapreferencia_new(Date fecha_voto_preferencia_new) {
		this.fecha_voto_preferencia_new = fecha_voto_preferencia_new;
	}

	public int getCantidad_puntos_new() {
		return cantidad_puntos_new;
	}

	public void setCantidad_puntos_new(int cantidad_puntos_new) {
		this.cantidad_puntos_new = cantidad_puntos_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
