package datos;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.ConnectionString;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.bulk.WriteRequest.Type;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import org.bson.Document;

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
	
}
