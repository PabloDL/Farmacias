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

	 public void consultaPunto1(){
		/*
		 * Requires the MongoDB Java Driver.
		 * https://mongodb.github.io/mongo-java-driver
		 */
		 
		System.out.println("Por Sucursal:");

		MongoClient mongoClient = new MongoClient(
		    new MongoClientURI(
		        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
		    )
		);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(group("$sucursal.idSucursal", sum("Total_sucursal", "$TotalVenta"))));
		
		MongoCursor<Document> it = result.iterator();
		while (it.hasNext()) {
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			//Obtengo el objeto a partir del json
			ObjetoConsulta1 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta1.class);
			System.out.println(totalesProducto.toString());
		}
		
		System.out.println("Por Cadena:");
		
		AggregateIterable<Document> result2 = collection.aggregate(Arrays.asList(group(null, sum("Total_sucursal", "$TotalVenta"))));
		
		MongoCursor<Document> it2 = result2.iterator();
		while (it2.hasNext()) {
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			//Obtengo el objeto a partir del json
			ObjetoConsulta1 totalesProducto = gson.fromJson(it2.next().toJson(), ObjetoConsulta1.class);
			System.out.println(totalesProducto.toString());
		}
	}
	 
	 public void consultaPunto2(){
		/*
		 * Requires the MongoDB Java Driver.
		 * https://mongodb.github.io/mongo-java-driver
		 */
		 

		MongoClient mongoClient = new MongoClient(
		    new MongoClientURI(
		        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
		    )
		);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");


		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
			    new java.util.Date(1591056000000L)), lte("fecha", 
			    	    new java.util.Date(1596499200000L)))), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("cliente", eq("obraSocial", eq("nombre", "$cliente.obraSocial.nombre")))), sum("Total_venta", "$TotalVenta"))));
		
		MongoCursor<Document> it = result.iterator();
		while (it.hasNext()) {
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.create();
			//Obtengo el objeto a partir del json
			ObjetoConsulta2 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta2.class);
			System.out.println(totalesProducto.toString());
		}
		
	}
	 
	 public void consultaPunto3(){
			/*
			 * Requires the MongoDB Java Driver.
			 * https://mongodb.github.io/mongo-java-driver
			 */
			System.out.println("\n");
			System.out.println("Por Sucursal:");

			MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");

			AggregateIterable<Document> result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L)))), unwind("$formaDePago", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("formaDePago", eq("descripcion", "$formaDePago.descripcion"))), sum("Total_cobranza", "$TotalVenta"))));
			
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
			System.out.println("\n");
			System.out.println("Por Cadena:");
			
			AggregateIterable<Document> result2 = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L)))), unwind("$formaDePago", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", 
				    	    new BsonNull()), eq("formaDePago", eq("descripcion", "$formaDePago.descripcion"))), sum("Total_cobranza", "$TotalVenta"))));
			
			MongoCursor<Document> it2 = result2.iterator();
			
			while (it2.hasNext()) {
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setPrettyPrinting();
				Gson gson = gsonBuilder.create();
				//System.out.println(it2.next().toJson());
				//Obtengo el objeto a partir del json
				ObjetoConsulta3 totalesProducto = gson.fromJson(it2.next().toJson(), ObjetoConsulta3.class);
				
				
				System.out.println(totalesProducto.toString());
				
			}
		}
	 
	 public void consultaPunto4PorCadena() {
		
		MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(match(and(gte("fecha", 
			    new java.util.Date(1593561600000L)), lte("fecha", 
			    	    new java.util.Date(1593648000000L)))), unwind("$productos", 
			    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", 
			    	    new BsonNull()), eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion")))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad"))));
	
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
	
	public void consultaPunto4PorSucursal() {
		
		MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		MongoCollection<Document> collection = database.getCollection("Tickets");
//1593572400
		AggregateIterable<Document> result =  collection.aggregate(Arrays.asList(match(and(gte("fecha", 
			    new java.util.Date(1593561600000L)), lte("fecha", 
			    	    new java.util.Date(1593648000000L)))), unwind("$productos", 
			    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion")))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad"))));
		
		//IMPRIMO RESULTADOS 
		MongoCursor<Document> it = result.iterator();
		while (it.hasNext()) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();
			gsonBuilder.registerTypeAdapter(Date.class, new GsonUTCDateAdapter());
			Gson gson = gsonBuilder.create();
			
			//Obtengo el objeto a partir del json
			ObjetoConsulta4 totalesProducto = gson.fromJson(it.next().toJson(), ObjetoConsulta4.class);
			
			//System.out.println(it.next().toJson());
			System.out.println(totalesProducto.toString());
		}
	
	}
		
	 public void consultaPunto7(){
			/*
			 * Requires the MongoDB Java Driver.
			 * https://mongodb.github.io/mongo-java-driver
			 */
			 System.out.println("\n");
			System.out.println("Por cadena:");

			MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");

			AggregateIterable<Document> result = collection.aggregate(Arrays.asList(match(and(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L))), eq("sucursal.idSucursal", 2L))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("cliente", "$cliente.nombre"), eq("apellido", "$cliente.apelido"), eq("dni", "$cliente.dni")), sum("Total_cobranza", "$TotalVenta")), sort(descending("Total_cobranza"))));
			
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
	
	 public void consultaPunto5PorSucursal(){
		 MongoClient mongoClient = new MongoClient(
				    new MongoClientURI(
				        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
				    )
				);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");
	//1593572400
			AggregateIterable<Document> result =  collection.aggregate(Arrays.asList(match(and(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L))), eq("sucursal.idSucursal", 1L))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("sucursal", "$sucursal.idSucursal"), eq("producto", and(eq("tipo", "$productos.producto.tipo"), eq("descripcion", "$productos.producto.descripcion")))), sum("Total_venta", "$TotalVenta"), sum("Cantidad_vendida", "$productos.cantidad")), sort(descending("Total_venta"))));
			
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
		 
	 public void consultaPunto8(){
			/*
			 * Requires the MongoDB Java Driver.
			 * https://mongodb.github.io/mongo-java-driver
			 */
			System.out.println("\n");
			System.out.println("Por Sucursal:");

			MongoClient mongoClient = new MongoClient(
			    new MongoClientURI(
			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
			    )
			);
			MongoDatabase database = mongoClient.getDatabase("Farma");
			MongoCollection<Document> collection = database.getCollection("Tickets");

			AggregateIterable<Document> result =collection.aggregate(Arrays.asList(match(and(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L))), eq("sucursal.idSucursal", 1L))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("cliente", "$cliente.nombre"), eq("apellido", "$cliente.apelido"), eq("dni", "$cliente.dni")), sum("Total_Productos", "$productos.cantidad")), sort(descending("Total_Productos"))));
			
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
			System.out.println("\n");
			System.out.println("Por Cadena:");
			
			AggregateIterable<Document> result2 =collection.aggregate(Arrays.asList(match(and(gte("fecha", 
				    new java.util.Date(1591056000000L)), lte("fecha", 
				    	    new java.util.Date(1596499200000L)))), unwind("$productos", 
				    	    new UnwindOptions().includeArrayIndex("string").preserveNullAndEmptyArrays(true)), group(and(eq("cliente", "$cliente.nombre"), eq("apellido", "$cliente.apelido"), eq("dni", "$cliente.dni")), sum("Total_Productos", "$productos.cantidad")), sort(descending("Total_Productos"))));
			
			MongoCursor<Document> it2 = result2.iterator();
			
			while (it2.hasNext()) {
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setPrettyPrinting();
				Gson gson = gsonBuilder.create();
				//System.out.println(it2.next().toJson());
				//Obtengo el objeto a partir del json
				ObjetoConsulta8 totalesProducto = gson.fromJson(it2.next().toJson(), ObjetoConsulta8.class);
				
				
				System.out.println(totalesProducto.toString());
				
			}
		}

	 
}
	
	
//	 public void consultaPunto4(){
//			/*
//			 * Requires the MongoDB Java Driver.
//			 * https://mongodb.github.io/mongo-java-driver
//			 */
//			 
//
//			MongoClient mongoClient = new MongoClient(
//			    new MongoClientURI(
//			        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false"
//			    )
//			);
//			MongoDatabase database = mongoClient.getDatabase("Farma");
//			MongoCollection<Document> collection = database.getCollection("Tickets");
//
//			AggregateIterable<Document> result = collection.aggregate(Arrays.asList(group("$sucursal.idSucursal", sum("Total de ventas por punto", "$TotalVenta"))));
//			
//			MongoCursor<Document> it = result.iterator();
//			while (it.hasNext()) {
//				
//				System.out.println(it.next().toJson());
//			}
//			
//			
//			result = collection.aggregate(Arrays.asList(and(gte("$fecha", new java.util.Date(1593648000000L)), lte("$fecha", new java.util.Date(1594080000000L))), group("$productos.producto.tipo", sum("Total de ventas de Farmacia", "$TotalVenta"))));
//			
//			it = result.iterator();
//			
//			while (it.hasNext()) {
//				
//				System.out.println(it.next().toJson());
//			}
//		}




