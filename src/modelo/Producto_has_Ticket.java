package modelo;

public class Producto_has_Ticket {
	
	private Producto producto;
	private int Ticket_nroTicket;
	private int precioUnitario;
	private int cantidad;
	private int total;
	
	public Producto_has_Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto_has_Ticket(Producto producto, int ticket_nroTicket, int precioUnitario, int cantidad, int total) {
		super();
		this.producto = producto;
		Ticket_nroTicket = ticket_nroTicket;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Producto_has_Ticket [producto=" + producto + ", Ticket_nroTicket=" + Ticket_nroTicket
				+ ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + ", total=" + total + "]";
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getTicket_nroTicket() {
		return Ticket_nroTicket;
	}

	public void setTicket_nroTicket(int ticket_nroTicket) {
		Ticket_nroTicket = ticket_nroTicket;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
			
	
		
}
