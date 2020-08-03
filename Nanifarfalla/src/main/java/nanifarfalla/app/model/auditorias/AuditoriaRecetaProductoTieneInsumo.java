package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rece_produ_ti_insumo")
public class AuditoriaRecetaProductoTieneInsumo {
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
	int fk_codigo_producto;
	int fk_codigo_insumo;
	int fk_codigo_elaboracionproducto;
	Date version;
	
	
	public AuditoriaRecetaProductoTieneInsumo() {
	
	}
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
	public int getFk_codigo_producto() {
		return fk_codigo_producto;
	}
	public void setFk_codigo_producto(int fk_codigo_producto) {
		this.fk_codigo_producto = fk_codigo_producto;
	}
	public int getFk_codigo_insumo() {
		return fk_codigo_insumo;
	}
	public void setFk_codigo_insumo(int fk_codigo_insumo) {
		this.fk_codigo_insumo = fk_codigo_insumo;
	}
	public int getFk_codigo_elaboracionproducto() {
		return fk_codigo_elaboracionproducto;
	}
	public void setFk_codigo_elaboracionproducto(int fk_codigo_elaboracionproducto) {
		this.fk_codigo_elaboracionproducto = fk_codigo_elaboracionproducto;
	}
	public Date getVersion() {
		return version;
	}
	public void setVersion(Date version) {
		this.version = version;
	}
	
	

}
