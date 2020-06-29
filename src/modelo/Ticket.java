package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Empleado; 
import modelo.Cliente;

public class Ticket {
	private int nroTicket;
	private Date fecha;
	private int TotalVenta;
	private FormaDePago formaDePago;
	private Empleado empleadoCaja;
	private Empleado empleadoAtencion;
	private Cliente cliente;
	private Sucursal sucursal;
	private List<Producto_has_Ticket> productos;
	
	public Ticket(int nroTicket, Date fecha, int totalVenta, FormaDePago formaDePago, Empleado empleadoCaja,
			Empleado empleadoAtencion, Cliente cliente, Sucursal sucursal) {
		super();
		this.nroTicket = nroTicket;
		this.fecha = fecha;
		TotalVenta = totalVenta;
		this.formaDePago = formaDePago;
		this.empleadoCaja = empleadoCaja;
		this.empleadoAtencion = empleadoAtencion;
		this.cliente = cliente;
		this.sucursal = sucursal;
		this.productos = new ArrayList<Producto_has_Ticket>();
		
	}
	
	public int getNroTicket() {
		return nroTicket;
	}
	
	private void setNroTicket(int nroTicket) {
		this.nroTicket = nroTicket;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getTotalVenta() {
		return TotalVenta;
	}
	
	public void setTotalVenta(int totalVenta) {
		TotalVenta = totalVenta;
	}
	
	public FormaDePago getFormaDePago() {
		return formaDePago;
	}
	
	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	public Empleado getEmpleadoCaja() {
		return empleadoCaja;
	}
	
	public void setEmpleadoCaja(Empleado empleadoCaja) {
		this.empleadoCaja = empleadoCaja;
	}
	
	public Empleado getEmpleadoAtencion() {
		return empleadoAtencion;
	}
	
	public void setEmpleadoAtencion(Empleado empleadoAtencion) {
		this.empleadoAtencion = empleadoAtencion;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Sucursal getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Producto_has_Ticket> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto_has_Ticket> productos) {
		this.productos = productos;
	}
	
	public void agregarProductos(Producto p, int cantidad) {
		Producto_has_Ticket nuevoProductoVendido = new Producto_has_Ticket(p.getCodigo(), this.nroTicket, p.getPrecio(), cantidad, (cantidad*p.getPrecio()));
		this.productos.add(nuevoProductoVendido);
	}
	
}
