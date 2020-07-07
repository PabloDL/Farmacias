package datos;

import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Accumulators.sum;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UnwindOptions;
import static com.mongodb.client.model.Sorts.descending;

import org.bson.BsonNull;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.sort;
import static com.mongodb.client.model.Aggregates.unwind;

import util.GsonUTCDateAdapter;
import util.ObjetoConsulta1;
import util.ObjetoConsulta2;
import util.ObjetoConsulta3;
import util.ObjetoConsulta4;
import util.ObjetoConsulta7;
import util.ObjetoConsulta8;

import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class consultor {
	
	public consultor() {
		super();
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE); 

	}

	 /*
	  * 1 - por sucursal
	  * -1 - por cadena 
	  * */
	 public void consultaPunto1(long sucursal){

		MongoClient mongoClient = new MongoClient(
		    new MongoClientURI(
		        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
		    )
		);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");

		AggregateIterable<Document> result;
		
		if (sucursal != -1) {
			System.out.println("Por Sucursal:");
			result = collection.aggregate(Arrays.asList(group("$sucursal.idSucursal", sum("Total_sucursal", "$TotalVenta"))));
		}
		else {
			System.out.println("Por Cadena:");
			result = collection.aggregate(Arrays.asList(group(null, sum("Total_sucursal", "$TotalVenta"))));
		}
		
		MongoCursor<Document> it = result.iterator();
		while (it.hasNext()) {
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			//Obtengo el objeto a partir del json
			ObjetoConsulta1 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta1.class);
			System.out.println(totalesProducto.toString());
		}
		
	}
	 
	 /*
	  * 1 - por sucursal
	  * -1 - por cadena 
	  * */
	 public void consultaPunto2(long sucursal){
		MongoClient mongoClient = new MongoClient(
		    new MongoClientURI(
		        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
		    )
		);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");

		AggregateIterable<Document> result;
		
		if (sucursal != -1) {
			System.out.println("Por sucursal:");
			result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
			    new java.util.Date(1591056000000L)), lte("fecha", 
			    	    new java.util.Date(1596499200000L)))), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("cliente", eq("obraSocial", eq("nombre", "$cliente.obraSocial.nombre")))), sum("Total_venta", "$TotalVenta"))));
		
		}
		else {
			System.out.println("Por cadena:");
			result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L)))), group(eq("cliente", eq("obraSocial", eq("nombre", "$cliente.obraSocial.nombre"))), sum("Total venta", "$TotalVenta"))));
		}
		
		MongoCursor<Document> it = result.iterator();
		while (it.hasNext()) {
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			//Obtengo el objeto a partir del json
			ObjetoConsulta2 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta2.class);
			System.out.println(totalesProducto.toString());
		}
		
	}
	 
	 /*
	  * 1 - por sucursal
	  * -1 - por cadena 
	  * */
	 public void consultaPunto3(long sucursal){
		
			MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");

			AggregateIterable<Document> result;
			
			if (sucursal != -1) {
				System.out.println("Por Sucursal:");
				result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L)))), unwind("$formaDePago", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("formaDePago", eq("descripcion", "$formaDePago.descripcion"))), sum("Total_cobranza", "$TotalVenta"))));
			}
			else {
				System.out.println("Por Cadena:");
				
				result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
					    new java.util.Date(1591056000000L)), lte("fecha", 
					    	    new java.util.Date(1596499200000L)))), unwind("$formaDePago", 
					    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", 
					    	    new BsonNull()), eq("formaDePago", eq("descripcion", "$formaDePago.descripcion"))), sum("Total_cobranza", "$TotalVenta"))));
			}
				
			MongoCursor<Document> it = result.iterator();
			while (it.hasNext()) {
				
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setPrettyPrinting();
				Gson gson = gsonBuilder.create();
				
				//Obtengo el objeto a partir del json
				ObjetoConsulta3 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta3.class);
				
				//System.out.println(it.next().toJson());
				System.out.println(totalesProducto.toString());
				//System.out.println(it.next().toJson());
			}
		
		}
	 
	 /*
	  * 1 - por sucursal
	  * -1 - por cadena 
	  * */
	 public void consultaPunto4(long idSucursal) {
		
		MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");

		AggregateIterable<Document> result;
		
		if (idSucursal != -1) {
			System.out.println("Por cadena:");
			
			result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
			    new java.util.Date(1593561600000L)), lte("fecha", 
			    	    new java.util.Date(1593648000000L)))), unwind("$productos", 
			    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", 
			    	    new BsonNull()), eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion")))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad"))));
		}
		else {
			System.out.println("Por Sucursal:");
			
			result =  collection.aggregate(Arrays.asList(match(and(gte("fecha", 
					    new java.util.Date(1593561600000L)), lte("fecha", 
					    	    new java.util.Date(1593648000000L)))), unwind("$productos", 
					    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion")))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad"))));
				
		}
		//IMPRIMO RESULTADOS 
		MongoCursor<Document> it = result.iterator();
		double sumaVentas = 0;
		
		while (it.hasNext()) {
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();
			gsonBuilder.registerTypeAdapter(Date.class, new GsonUTCDateAdapter());
			Gson gson = gsonBuilder.create();
			
			//Obtengo el objeto a partir del json
			ObjetoConsulta4 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta4.class);
			
			//System.out.println(it.next().toJson());
			System.out.println(totalesProducto.toString());
			sumaVentas = sumaVentas + totalesProducto.getTotal_venta();
		}
		System.out.println("TOTAL DE VENTAS POR CADENA " + sumaVentas);
	
	}
	
	 /*
	  * 1 - por sucursal
	  * -1 - por cadena 
	  * */
	 public void consultaPunto6(long idSucursal) {
		
		MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");

		AggregateIterable<Document> result;
		
		if (idSucursal != -1) {
			
			System.out.println("Por Sucursal:");
			result =collection.aggregate(Arrays.asList(match(and(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L))), eq("sucursal.idSucursal", idSucursal))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion")))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad")), sort(descending("Cantidad_vendida"))));  
		}
		else {
			System.out.println("Por cadena:");
			
			result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L)))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion"))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad")), sort(descending("Cantidad_vendida"))));
				
		}
		//IMPRIMO RESULTADOS 
		MongoCursor<Document> it = result.iterator();
		
		while (it.hasNext()) {
		
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();
			gsonBuilder.registerTypeAdapter(Date.class, new GsonUTCDateAdapter());
			Gson gson = gsonBuilder.create();
			
			//Obtengo el objeto a partir del json
			//usa ObjetoConsulta4 porque el set de datos del json es igual aunque los montos y ordenamiento no lo es 
			ObjetoConsulta4 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta4.class);
				
			System.out.println(totalesProducto.toString());
			
		}
	
	}
	
	 /*
	  * SI NO EXISTE SUCURSAL SE PASA -1 
	  * */
	 public void consultaPunto7(long idSucursal){

			MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");

			AggregateIterable<Document> result;
			
			if (idSucursal != -1) {
				System.out.println("Por sucursal:");
				result = collection.aggregate(Arrays.asList(match(and(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L))), eq("sucursal.idSucursal", 2L))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("cliente", "$cliente.nombre"), eq("apellido", "$cliente.apelido"), eq("dni", "$cliente.dni")), sum("Total_cobranza", "$TotalVenta")), sort(descending("Total_cobranza"))));
			}
			else {
				System.out.println("Por cadena:");
				result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
						    new java.util.Date(1591056000000L)), lte("fecha", 
						    new java.util.Date(1596499200000L)))), unwind("$productos", 
						    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("cliente", "$cliente.nombre"), eq("apellido", "$cliente.apelido"), eq("dni", "$cliente.dni")), sum("Total_cobranza", "$TotalVenta")), sort(descending("Total_cobranza"))));
			}
			
			MongoCursor<Document> it = result.iterator();
			while (it.hasNext()) {
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setPrettyPrinting();
				gsonBuilder.registerTypeAdapter(Date.class, new GsonUTCDateAdapter());
				Gson gson = gsonBuilder.create();
				
				//Obtengo el objeto a partir del json
				ObjetoConsulta7 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta7.class);
				
				//System.out.println(it.next().toJson());
				System.out.println(totalesProducto.toString());
			}
			
		}
		 
	 /*
	  * SI NO EXISTE SUCURSAL SE PASA -1 
	  * */
	 public void consultaPunto5(long idSucursal){
		 MongoClient mongoClient = new MongoClient(
				    new MongoClientURI(
				        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
				    )
				);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");
	//1593572400
			AggregateIterable<Document> result;
			if (idSucursal != -1) {
			result =  collection.aggregate(Arrays.asList(match(and(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L))), eq("sucursal.idSucursal", idSucursal))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion")))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad")), sort(descending("Total_venta"))));
			}
			else {
				 result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
						    new java.util.Date(1591056000000L)), lte("fecha", 
						    	    new java.util.Date(1596499200000L)))), unwind("$productos", 
						    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion"))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad")), sort(descending("Total_venta"))));
			}
			//IMPRIMO RESULTADOS 
			MongoCursor<Document> it = result.iterator();
			while (it.hasNext()) {
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setPrettyPrinting();
				gsonBuilder.registerTypeAdapter(Date.class, new GsonUTCDateAdapter());
				Gson gson = gsonBuilder.create();
				
				//Obtengo el objeto a partir del json  - ES IGUAL A FORMATO DE CONSULTA 4
				ObjetoConsulta4 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta4.class);
				
				//System.out.println(it.next().toJson());
				System.out.println(totalesProducto.toString());
				
			}
		
		}
	
	 /*
	  * SI NO EXISTE SUCURSAL SE PASA -1 
	  * */
	 public void consultaPunto8(long idSucursal){
			
			MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");

			AggregateIterable<Document> result;
			if (idSucursal != -1) {
				System.out.println("Por Sucursal:");
				
				result =collection.aggregate(Arrays.asList(match(and(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L))), eq("sucursal.idSucursal", idSucursal))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("cliente", "$cliente.nombre"), eq("apellido", "$cliente.apelido"), eq("dni", "$cliente.dni")), sum("Total_Productos", "$productos.cantidad")), sort(descending("Total_Productos"))));
			}
			else {
	
				System.out.println("Por Cadena:");
				
				result =collection.aggregate(Arrays.asList(match(and(gte("fecha", 
					    new java.util.Date(1591056000000L)), lte("fecha", 
					    	    new java.util.Date(1596499200000L)))), unwind("$productos", 
					    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("cliente", "$cliente.nombre"), eq("apellido", "$cliente.apelido"), eq("dni", "$cliente.dni")), sum("Total_Productos", "$productos.cantidad")), sort(descending("Total_Productos"))));
			}
			
			
			MongoCursor<Document> it = result.iterator();
			while (it.hasNext()) {
				
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setPrettyPrinting();
				Gson gson = gsonBuilder.create();
				
				//Obtengo el objeto a partir del json
				ObjetoConsulta8 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta8.class);
				
				//System.out.println(it.next().toJson());
				System.out.println(totalesProducto.toString());
				//System.out.println(it.next().toJson());
			}
			
	 }
	 
}
	