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
@Table(name = "catalogo")
public class Catalogo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_catalogo;
	int cat_codigo_producto;
	String cat_nombre_producto;
	String cat_nombre_tipo_producto;
	Double cat_densidad;
	Double valor_con_igv;
	Double cat_valor_neto;
	Double cat_valor_con_igv;
	String cat_preparacion_producto;
	String cat_colores_producto;
	String cat_nombre_insumo;
	String cat_modelo_receta_producto;
	int cantidadMasPedido;
	Double promedioTotalProd;

	@JoinColumn(name = "fkcodigo_estadoCatalogo", referencedColumnName = "codigo_estadoCatalogo")
	@ManyToOne
	EstadoCatalogo mEstadoCatalogo;

	// int fkcodigo_estadoCatalogo;
	Date version;

	public Catalogo() {

	}

	public int getCodigo_catalogo() {
		return codigo_catalogo;
	}

	public void setCodigo_catalogo(int codigo_catalogo) {
		this.codigo_catalogo = codigo_catalogo;
	}

	public int getCat_codigo_producto() {
		return cat_codigo_producto;
	}

	public void setCat_codigo_producto(int cat_codigo_producto) {
		this.cat_codigo_producto = cat_codigo_producto;
	}

	public String getCat_nombre_producto() {
		return cat_nombre_producto;
	}

	public void setCat_nombre_producto(String cat_nombre_producto) {
		this.cat_nombre_producto = cat_nombre_producto;
	}

	public String getCat_nombre_tipo_producto() {
		return cat_nombre_tipo_producto;
	}

	public void setCat_nombre_tipo_producto(String cat_nombre_tipo_producto) {
		this.cat_nombre_tipo_producto = cat_nombre_tipo_producto;
	}

	public Double getCat_densidad() {
		return cat_densidad;
	}

	public void setCat_densidad(Double cat_densidad) {
		this.cat_densidad = cat_densidad;
	}

	public Double getValor_con_igv() {
		return valor_con_igv;
	}

	public void setValor_con_igv(Double valor_con_igv) {
		this.valor_con_igv = valor_con_igv;
	}

	public Double getCat_valor_neto() {
		return cat_valor_neto;
	}

	public void setCat_valor_neto(Double cat_valor_neto) {
		this.cat_valor_neto = cat_valor_neto;
	}

	public Double getCat_valor_con_igv() {
		return cat_valor_con_igv;
	}

	public void setCat_valor_con_igv(Double cat_valor_con_igv) {
		this.cat_valor_con_igv = cat_valor_con_igv;
	}

	public String getCat_preparacion_producto() {
		return cat_preparacion_producto;
	}

	public void setCat_preparacion_producto(String cat_preparacion_producto) {
		this.cat_preparacion_producto = cat_preparacion_producto;
	}

	public String getCat_colores_producto() {
		return cat_colores_producto;
	}

	public void setCat_colores_producto(String cat_colores_producto) {
		this.cat_colores_producto = cat_colores_producto;
	}

	public String getCat_nombre_insumo() {
		return cat_nombre_insumo;
	}

	public void setCat_nombre_insumo(String cat_nombre_insumo) {
		this.cat_nombre_insumo = cat_nombre_insumo;
	}

	public String getCat_modelo_receta_producto() {
		return cat_modelo_receta_producto;
	}

	public void setCat_modelo_receta_producto(String cat_modelo_receta_producto) {
		this.cat_modelo_receta_producto = cat_modelo_receta_producto;
	}

	public int getCantidadMasPedido() {
		return cantidadMasPedido;
	}

	public void setCantidadMasPedido(int cantidadMasPedido) {
		this.cantidadMasPedido = cantidadMasPedido;
	}

	public Double getPromedioTotalProd() {
		return promedioTotalProd;
	}

	public void setPromedioTotalProd(Double promedioTotalProd) {
		this.promedioTotalProd = promedioTotalProd;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
