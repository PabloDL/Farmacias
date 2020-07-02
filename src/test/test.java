package test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import datos.consultor;

public class test {
	public static void main (String [ ] args) {
		
		//Persistir datos
		Persistidor persistidor = new Persistidor();
		persistidor.persistirTickets(cargarTicketsGenericos(1));
		
		//Consultar datos
		consultor consultor = new consultor();
		System.out.print("CONSUTA 1:\n");
		consultor.consultaPunto1();
		System.out.print("\n");
		
		System.out.print("CONSULTA 2:\n");
		consultor.consultaPunto2();
		System.out.print("\n");
		
//		System.out.print("CONSULTA 4:\n");
//		consultor.consultaPunto4();
//		System.out.print("\n");
	}
	
	@SuppressWarnings("deprecation")
	public static List<String> cargarTicketsGenericos(int cantAGenerar) {
		
		//creo 2 obras sociales
		ObraSocial oS1 = new ObraSocial(1, "OSde");
		ObraSocial oS2 = new ObraSocial(2, "Accord");
		
		//Creo 6 Clientes		
     	Cliente c1 = new Cliente(1, "Jose", "Perez", new Domicilio(1, "calle", 100, "localidad", "Provincia"), oS1);		
		Cliente c2 = new Cliente(2, "Juan", "Gomez", new Domicilio(2, "calle", 200, "localidad", "Provincia"), oS2);	
		Cliente c3 = new Cliente(3, "Jorge", "Gonzalez", new Domicilio(3, "calle", 300, "localidad", "Provincia") , oS1);
		Cliente c4 = new Cliente(4, "Pedro", "Picapiedras", new Domicilio(4, "calle", 400, "localidad", "Provincia") , oS2);
		Cliente c5 = new Cliente(5, "Super", "Sonico", new Domicilio(5, "calle", 500, "localidad", "Provincia") , oS1);		
		Cliente c6 = new Cliente(6, "Stephen", "Strange", new Domicilio(6, "calle", 600, "localidad", "Provincia") , oS2);
		
		//Creo 3 empleados
		Empleado e1 = new Empleado(1,"Bruce","Banner","222222222",oS1, new Domicilio(7, "calle", 700, "localidad", "Provincia") );
		Empleado e2 = new Empleado(2,"Anthony","Stark","222222222",oS2, new Domicilio(8, "calle", 800, "localidad", "Provincia") );
		Empleado e3 = new Empleado(3,"Steven","Rogers","222222222",oS1, new Domicilio(9, "calle", 900, "localidad", "Provincia") );
		Empleado e4 = new Empleado(4,"Hank","Pym","222222222",oS1, new Domicilio(12, "calle", 900, "localidad", "Provincia") );
		
		//Creo 5 productos
		Producto p1 = new Producto(1, "Farmacia","Ibuprofeno","laboratorio",100);
		Producto p2 = new Producto(2, "Farmacia","Paracetamol","laboratorio",50);
		Producto p3 = new Producto(3, "Perfumeria","Perfume","laboratorio",1200);
		Producto p4 = new Producto(4, "Farmacia","Curitas","laboratorio",10);
		Producto p5 = new Producto(51, "Farmacia","Amoxidal","laboratorio",75);
		
		//creo 2 sucursales
		Sucursal s1 = new Sucursal(1, 1, new Domicilio(10, "calle", 1000, "localidad", "Provincia") , e1);
		Sucursal s2 = new Sucursal(2, 2, new Domicilio(11, "calle", 1100, "localidad", "Provincia") , e2);
		
		//Creo 3 formas de pago
		FormaDePago f1 = new FormaDePago(1,"Efectivo");
		FormaDePago f2 = new FormaDePago(2,"Debito");
		FormaDePago f3 = new FormaDePago(2,"Credito");
	
		Date fecha1 = new Date();
		fecha1.setDate(1);		
		//TICKETS DIA 1
		Ticket t1 = new Ticket(1, fecha1, 100, f1, e1, e2, c1,s1);
		t1.agregarProductos(p1, 1);
		
		Ticket t2 = new Ticket(2, fecha1, 200, f2, e1, e2, c2,s1);
		t2.agregarProductos(p1, 2);
		
		Ticket t3 = new Ticket(3, fecha1, 150, f3, e3, e4, c3,s2);
		t3.agregarProductos(p1, 1);
		t3.agregarProductos(p2, 1);
		
		Ticket t4 = new Ticket(4, fecha1, 1200, f1, e3, e4, c4,s2);
		t4.agregarProductos(p3, 1);
		//TICKETS DIA 2
		Date fecha2 = new Date();
		fecha2.setDate(2);
		Ticket t5 = new Ticket(5, fecha2, 100, f1, e1, e2, c5,s1);
		t5.agregarProductos(p2, 2);
		//TICKETS DIA 4
		Date fecha3 = new Date();
		fecha3.setDate(4);
		Ticket t6 = new Ticket(6, fecha3, 400, f2, e3, e4, c6,s2);
		t6.agregarProductos(p3, 3);
		t6.agregarProductos(p4, 10);
		
		Ticket t7 = new Ticket(7, fecha3, 75, f2, e3, e4, c6,s2);
		t7.agregarProductos(p5, 1);
		
		Ticket t8 = new Ticket(8, fecha3, 100, f3, e3, e4, c6,s2);
		t8.agregarProductos(p1, 1);
		//TICKETS DIA 6
		Date fecha4 = new Date();
		fecha4.setDate(6);
		Ticket t9 = new Ticket(9, fecha4, 1200, f3, e1, e2, c2,s1);
		Ticket t10 = new Ticket(10, fecha4, 500, f3, e3, e4, c2,s2);
		
		List<String> listaTickets = new ArrayList<String>();
		
		SerializadorTicket serializador = new SerializadorTicket();
		String jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t1);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t2);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t3);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t4);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t5);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t6);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t7);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t8);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t9);
		listaTickets.add(jsonTicket);
		
		serializador = new SerializadorTicket();
		jsonTicket = serializador.debeDevolverLaRepresentacionJSONDeUnObjeto(t10);
		listaTickets.add(jsonTicket);
		
	
		return listaTickets;
		
	}
	
}
