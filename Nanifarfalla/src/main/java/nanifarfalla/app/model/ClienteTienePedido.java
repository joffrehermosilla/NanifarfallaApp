package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_tiene_pedido")
public class ClienteTienePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_pedido_web;

	@JoinColumn(name = "fkcodigo_cliente", referencedColumnName = "codigo_cliente")
	@ManyToOne
	Cliente mCliente;

	@JoinColumn(name = "fkcodigo_vendedor", referencedColumnName = "codigo_vendedor")
	@ManyToOne
	Vendedor mVendedor;

	@JoinColumn(name = "fkcodigo_promocion_venta", referencedColumnName = "codigo_promocion_venta")
	@ManyToOne
	PromocionVenta mPromocion_venta;

	@JoinColumn(name = "fkcodigo_estado_cliente_tiene_pedido", referencedColumnName = "codigo_estado_cliente_tiene_pedido")
	@ManyToOne
	EstadoClienteTienePedido mEstadoClienteTienePedido;

	@JoinColumn(name = "fkcodigo_factura_cliente_tiene_pedido", referencedColumnName = "codigo_factura_cliente_tiene_pedido")
	@ManyToOne
	FacturaClienteTienePedido mFactura_cliente_tiene_pedido;

	@JoinColumn(name = "fkcodigo_igv_venta", referencedColumnName = "codigo_igv_venta")
	@ManyToOne
	IgvVenta mIgv_venta;

	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;

	@OneToMany(mappedBy = "mClientetienepedido")
	private Collection<ProductoxPedido> productoxpedido = new ArrayList<>();

	@OneToMany(mappedBy = "mClienteTienePedido")
	private Collection<Contrato> contratos = new ArrayList<>();
//	int fkcodigo_usuario;
//	int fkcodigo_cliente;
//	int fkcodigo_vendedor;
//	int fkcodigo_igv_venta;
//	int fkcodigo_promocion_venta;
//	int fkcodigo_estado_cliente_tiene_pedido;
//	int fkcodigo_factura_cliente_tiene_pedido;
	Double descuento_web_pedido;
	Double precio_uni_desc_igv;
	Double precio_uni_desc_sin_igv;
	Date fecha_pedido;
	Date fecha_entrega;
	int cantidad_producto;
	Double monto_por_descuentos;
	String claveApi;
	Date version;

	public ClienteTienePedido() {

	}

	public Collection<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Collection<Contrato> contratos) {
		this.contratos = contratos;
	}

	public int getCodigo_pedido_web() {
		return codigo_pedido_web;
	}

	public void setCodigo_pedido_web(int codigo_pedido_web) {
		this.codigo_pedido_web = codigo_pedido_web;
	}

	public Cliente getmCliente() {
		return mCliente;
	}

	public void setmCliente(Cliente mCliente) {
		this.mCliente = mCliente;
	}

	public Vendedor getmVendedor() {
		return mVendedor;
	}

	public void setmVendedor(Vendedor mVendedor) {
		this.mVendedor = mVendedor;
	}

	public PromocionVenta getmPromocion_venta() {
		return mPromocion_venta;
	}

	public void setmPromocion_venta(PromocionVenta mPromocion_venta) {
		this.mPromocion_venta = mPromocion_venta;
	}

	public EstadoClienteTienePedido getmEstadoClienteTienePedido() {
		return mEstadoClienteTienePedido;
	}

	public void setmEstadoClienteTienePedido(EstadoClienteTienePedido mEstadoClienteTienePedido) {
		this.mEstadoClienteTienePedido = mEstadoClienteTienePedido;
	}

	public FacturaClienteTienePedido getmFactura_cliente_tiene_pedido() {
		return mFactura_cliente_tiene_pedido;
	}

	public void setmFactura_cliente_tiene_pedido(FacturaClienteTienePedido mFactura_cliente_tiene_pedido) {
		this.mFactura_cliente_tiene_pedido = mFactura_cliente_tiene_pedido;
	}

	public IgvVenta getmIgv_venta() {
		return mIgv_venta;
	}

	public void setmIgv_venta(IgvVenta mIgv_venta) {
		this.mIgv_venta = mIgv_venta;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
	}

	public Collection<ProductoxPedido> getProductoxpedido() {
		return productoxpedido;
	}

	public void setProductoxpedido(Collection<ProductoxPedido> productoxpedido) {
		this.productoxpedido = productoxpedido;
	}

	public Double getDescuento_web_pedido() {
		return descuento_web_pedido;
	}

	public void setDescuento_web_pedido(Double descuento_web_pedido) {
		this.descuento_web_pedido = descuento_web_pedido;
	}

	public Double getPrecio_uni_desc_igv() {
		return precio_uni_desc_igv;
	}

	public void setPrecio_uni_desc_igv(Double precio_uni_desc_igv) {
		this.precio_uni_desc_igv = precio_uni_desc_igv;
	}

	public Double getPrecio_uni_desc_sin_igv() {
		return precio_uni_desc_sin_igv;
	}

	public void setPrecio_uni_desc_sin_igv(Double precio_uni_desc_sin_igv) {
		this.precio_uni_desc_sin_igv = precio_uni_desc_sin_igv;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Double getMonto_por_descuentos() {
		return monto_por_descuentos;
	}

	public void setMonto_por_descuentos(Double monto_por_descuentos) {
		this.monto_por_descuentos = monto_por_descuentos;
	}

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
