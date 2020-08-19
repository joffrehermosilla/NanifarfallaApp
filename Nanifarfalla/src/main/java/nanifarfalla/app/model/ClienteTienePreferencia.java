package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class ClienteTienePreferencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_preferencia_sku;
	@JoinColumn(name = "fkcodigo_cliente", referencedColumnName = "codigo_cliente")
	@ManyToOne
	Cliente mCliente;
	// int fkcodigo_cliente;

	@JoinColumn(name = "fkcodigo_producto", referencedColumnName = "codigo_producto")
	@ManyToOne
	Producto mProducto;
	// int fkcodigo_producto;
	Date fecha_voto_preferencia;
	int cantidad_puntos;
	Date version;

	public ClienteTienePreferencia() {

	}

	public int getCodigo_preferencia_sku() {
		return codigo_preferencia_sku;
	}

	public void setCodigo_preferencia_sku(int codigo_preferencia_sku) {
		this.codigo_preferencia_sku = codigo_preferencia_sku;
	}

	public Cliente getmCliente() {
		return mCliente;
	}

	public void setmCliente(Cliente mCliente) {
		this.mCliente = mCliente;
	}

	public Producto getmProducto() {
		return mProducto;
	}

	public void setmProducto(Producto mProducto) {
		this.mProducto = mProducto;
	}

	public Date getFecha_voto_preferencia() {
		return fecha_voto_preferencia;
	}

	public void setFecha_voto_preferencia(Date fecha_voto_preferencia) {
		this.fecha_voto_preferencia = fecha_voto_preferencia;
	}

	public int getCantidad_puntos() {
		return cantidad_puntos;
	}

	public void setCantidad_puntos(int cantidad_puntos) {
		this.cantidad_puntos = cantidad_puntos;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
