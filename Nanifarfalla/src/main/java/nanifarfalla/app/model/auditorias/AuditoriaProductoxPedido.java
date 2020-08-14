package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_producto_por_pedido")
public class AuditoriaProductoxPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_producto_por_pedido;
	int fkcodigo_pedido_web_old;
	int fkcodigo_producto_old;
	Double descuento_promocion_old;
	Double valor_neto_old;
	Double valor_con_igv_old;
	int cantidad_producto_old;
	Date version_old;
	int fkcodigo_pedido_web_new;
	int fkcodigo_producto_new;
	Double descuento_promocion_new;
	Double valor_neto_new;
	Double valor_con_igv_new;
	int cantidad_producto_new;
	Date version_new;

	public AuditoriaProductoxPedido() {

	}

	public int getCodigo_audi_producto_por_pedido() {
		return codigo_audi_producto_por_pedido;
	}

	public void setCodigo_audi_producto_por_pedido(int codigo_audi_producto_por_pedido) {
		this.codigo_audi_producto_por_pedido = codigo_audi_producto_por_pedido;
	}

	public int getFkcodigo_pedido_web_old() {
		return fkcodigo_pedido_web_old;
	}

	public void setFkcodigo_pedido_web_old(int fkcodigo_pedido_web_old) {
		this.fkcodigo_pedido_web_old = fkcodigo_pedido_web_old;
	}

	public int getFkcodigo_producto_old() {
		return fkcodigo_producto_old;
	}

	public void setFkcodigo_producto_old(int fkcodigo_producto_old) {
		this.fkcodigo_producto_old = fkcodigo_producto_old;
	}

	public Double getDescuento_promocion_old() {
		return descuento_promocion_old;
	}

	public void setDescuento_promocion_old(Double descuento_promocion_old) {
		this.descuento_promocion_old = descuento_promocion_old;
	}

	public Double getValor_neto_old() {
		return valor_neto_old;
	}

	public void setValor_neto_old(Double valor_neto_old) {
		this.valor_neto_old = valor_neto_old;
	}

	public Double getValor_con_igv_old() {
		return valor_con_igv_old;
	}

	public void setValor_con_igv_old(Double valor_con_igv_old) {
		this.valor_con_igv_old = valor_con_igv_old;
	}

	public int getCantidad_producto_old() {
		return cantidad_producto_old;
	}

	public void setCantidad_producto_old(int cantidad_producto_old) {
		this.cantidad_producto_old = cantidad_producto_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_pedido_web_new() {
		return fkcodigo_pedido_web_new;
	}

	public void setFkcodigo_pedido_web_new(int fkcodigo_pedido_web_new) {
		this.fkcodigo_pedido_web_new = fkcodigo_pedido_web_new;
	}

	public int getFkcodigo_producto_new() {
		return fkcodigo_producto_new;
	}

	public void setFkcodigo_producto_new(int fkcodigo_producto_new) {
		this.fkcodigo_producto_new = fkcodigo_producto_new;
	}

	public Double getDescuento_promocion_new() {
		return descuento_promocion_new;
	}

	public void setDescuento_promocion_new(Double descuento_promocion_new) {
		this.descuento_promocion_new = descuento_promocion_new;
	}

	public Double getValor_neto_new() {
		return valor_neto_new;
	}

	public void setValor_neto_new(Double valor_neto_new) {
		this.valor_neto_new = valor_neto_new;
	}

	public Double getValor_con_igv_new() {
		return valor_con_igv_new;
	}

	public void setValor_con_igv_new(Double valor_con_igv_new) {
		this.valor_con_igv_new = valor_con_igv_new;
	}

	public int getCantidad_producto_new() {
		return cantidad_producto_new;
	}

	public void setCantidad_producto_new(int cantidad_producto_new) {
		this.cantidad_producto_new = cantidad_producto_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
