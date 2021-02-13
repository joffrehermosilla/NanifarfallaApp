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
	
	

}
