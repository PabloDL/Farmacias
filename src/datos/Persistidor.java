package datos;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import modelo.Ticket;
import util.GsonUTCDateAdapter;

import static com.mongodb.client.model.Filters.*;

public class Persistidor {
	
	
	public void persistirTicket(String jsonTicket) {
		MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
		MongoClient mongoClient = new MongoClient(connectionString);
		MongoDatabase database = mongoClient.getDatabase("Farma");
	
		
	//PARSEAR
		//Abro collecion si existe, sino la creo
		MongoCollection<Document> collection =  database.getCollection("Tickets");		
     	//convierto el json en map para insertarlo
		Gson gson = new Gson();
		Map map = gson.fromJson(jsonTicket, Map.class);
        Document documentoTicket = new Document(map);
		
        //inserto en coleccion
		collection.insertOne(documentoTicket);	
	}
	
	public void persistirTickets(List<String> jsonTickets) {
		MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient(connectionString);
		MongoDatabase database = mongoClient.getDatabase("Farma");
		
	//PARSEAR
		//Abro collecion si existe, sino la creo
		MongoCollection<Document> collection =  database.getCollection("Tickets");		
     	//convierto el json en map para insertarlo
	
		Iterator<String> it = jsonTickets.iterator();
		
		while (it.hasNext()) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();
			gsonBuilder.registerTypeAdapter(Date.class, new GsonUTCDateAdapter());
			
			Gson gson = gsonBuilder.create();
			
			String aInsertar = new String(it.next());
			
			Ticket tAInsertar = gson.fromJson(aInsertar, Ticket.class);
			
			Map map = gson.fromJson(aInsertar, Map.class);
	        Document documentoTicket = new Document(map);
	        
	        //Document doc = Document.parse( aInsertar);
	        
	        if (collection.find(eq("nroTicket", tAInsertar.getNroTicket())).first() == null) {
		        //Si no existe inserto en coleccion
	        	//System.out.print("NO existe registro");
	        	//System.out.print("\n");
				collection.insertOne(documentoTicket);	        	
	        }
	        else {	        //Si no existe informo
	        	//System.out.print("Ya existe registro");
	        	//System.out.print("\n");
	        }	     
		}
		
	}
	
}
