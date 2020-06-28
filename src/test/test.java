package test;

import java.util.Date;

import modelo.Cliente;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.FormaDePago;
import modelo.ObraSocial;
import modelo.Producto;
import modelo.SerializadorTicket;
import modelo.Sucursal;
import modelo.Ticket;
import datos.Persistidor;

public class test {
	public static void main (String [ ] args) {
		System.out.print("test");
		
		Domicilio d = new Domicilio(1, "calle", 123, "localidad", "Provincia");
		ObraSocial oS = new ObraSocial(1, "Obra Social");
		
		Cliente c = new Cliente(33211333, "Jose", "Perez", d, oS);
		Empleado eAtendio = new Empleado(1,"Atendio","Lo","222222222",oS,d);
		Empleado eCobro = new Empleado(2,"Cobro","Le","222222223",oS,d);
		Producto p = new Producto(111,"producto","descripcion","laboratorio",123);
		Sucursal s = new Sucursal(1, 123, d, eCobro);
		FormaDePago f = new FormaDePago(1,"Efectivo");
		Date fecha = new Date();
		Ticket t = new Ticket(1, fecha, 200, f, eCobro, eAtendio, c,s);
		
		SerializadorTicket serializador = new SerializadorTicket();
		String jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t);
			
		//Persistir datos
		Persistidor persistidor = new Persistidor();
		persistidor.persistirTicket(jsonTicket);
		
		
	}
}
