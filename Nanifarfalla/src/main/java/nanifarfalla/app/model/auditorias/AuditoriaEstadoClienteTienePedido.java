package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_e_cli_tiene_pedido")
public class AuditoriaEstadoClienteTienePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_e_cli_tiene_pedido;
	String usuario;
	Date fecha_cambio;
	String nombre_estado_cliente_tiene_pedido_old;
	String claveApi_old;
	Date version_old;
	String nombre_estado_cliente_tiene_pedido_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaEstadoClienteTienePedido() {

	}

	public int getCodigo_audi_e_cli_tiene_pedido() {
		return codigo_audi_e_cli_tiene_pedido;
	}

	public void setCodigo_audi_e_cli_tiene_pedido(int codigo_audi_e_cli_tiene_pedido) {
		this.codigo_audi_e_cli_tiene_pedido = codigo_audi_e_cli_tiene_pedido;
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

	public String getNombre_estado_cliente_tiene_pedido_old() {
		return nombre_estado_cliente_tiene_pedido_old;
	}

	public void setNombre_estado_cliente_tiene_pedido_old(String nombre_estado_cliente_tiene_pedido_old) {
		this.nombre_estado_cliente_tiene_pedido_old = nombre_estado_cliente_tiene_pedido_old;
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

	public String getNombre_estado_cliente_tiene_pedido_new() {
		return nombre_estado_cliente_tiene_pedido_new;
	}

	public void setNombre_estado_cliente_tiene_pedido_new(String nombre_estado_cliente_tiene_pedido_new) {
		this.nombre_estado_cliente_tiene_pedido_new = nombre_estado_cliente_tiene_pedido_new;
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
