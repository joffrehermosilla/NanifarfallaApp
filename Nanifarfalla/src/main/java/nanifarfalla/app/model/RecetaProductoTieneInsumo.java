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
@Table(name = "rece_produ_ti_insumo")
public class RecetaProductoTieneInsumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_rece_produ_ti_insumo;
	Double cantidad_usada;
	Date fecha_creacion;
	String descripcion;
	Double dimension_altura;
	Double dimension_anchura;
	Double dimension_espesor;
	Double dimension_profundidad;
	Double porcentaje_en_producto;

	@JoinColumn(name = "fk_codigo_producto", referencedColumnName = "codigo_producto")
	@ManyToOne
	Producto mProducto;

//	fk_codigo_producto	
	@JoinColumn(name = "fk_codigo_insumo", referencedColumnName = "codigo_insumo")
	@ManyToOne
	Insumo mInsumo;
//	fk_codigo_insumo	

	@JoinColumn(name = "fk_codigo_elaboracionproducto", referencedColumnName = "codigo_elaboracionproducto")
	@ManyToOne
	ElaboracionProducto mElaboracionProducto;

	// fk_codigo_elaboracionproducto

	Date version;

	public int getCodigo_rece_produ_ti_insumo() {
		return codigo_rece_produ_ti_insumo;
	}

	public void setCodigo_rece_produ_ti_insumo(int codigo_rece_produ_ti_insumo) {
		this.codigo_rece_produ_ti_insumo = codigo_rece_produ_ti_insumo;
	}

	public Double getCantidad_usada() {
		return cantidad_usada;
	}

	public void setCantidad_usada(Double cantidad_usada) {
		this.cantidad_usada = cantidad_usada;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getDimension_altura() {
		return dimension_altura;
	}

	public void setDimension_altura(Double dimension_altura) {
		this.dimension_altura = dimension_altura;
	}

	public Double getDimension_anchura() {
		return dimension_anchura;
	}

	public void setDimension_anchura(Double dimension_anchura) {
		this.dimension_anchura = dimension_anchura;
	}

	public Double getDimension_espesor() {
		return dimension_espesor;
	}

	public void setDimension_espesor(Double dimension_espesor) {
		this.dimension_espesor = dimension_espesor;
	}

	public Double getDimension_profundidad() {
		return dimension_profundidad;
	}

	public void setDimension_profundidad(Double dimension_profundidad) {
		this.dimension_profundidad = dimension_profundidad;
	}

	public Double getPorcentaje_en_producto() {
		return porcentaje_en_producto;
	}

	public void setPorcentaje_en_producto(Double porcentaje_en_producto) {
		this.porcentaje_en_producto = porcentaje_en_producto;
	}

	public Producto getmProducto() {
		return mProducto;
	}

	public void setmProducto(Producto mProducto) {
		this.mProducto = mProducto;
	}

	public Insumo getmInsumo() {
		return mInsumo;
	}

	public void setmInsumo(Insumo mInsumo) {
		this.mInsumo = mInsumo;
	}

	public ElaboracionProducto getmElaboracionProducto() {
		return mElaboracionProducto;
	}

	public void setmElaboracionProducto(ElaboracionProducto mElaboracionProducto) {
		this.mElaboracionProducto = mElaboracionProducto;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}


	
	

}
