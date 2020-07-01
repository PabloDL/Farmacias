package datos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Accumulators.sum;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Aggregates.match;

public class consultor {

	 public void consultaPunto1(){
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

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(group("$sucursal.idSucursal", sum("Total de ventas por punto", "$TotalVenta"))));
		
		MongoCursor<Document> it = result.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next().toJson());
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
	    new java.util.Date(1590969600000L)), lte("fecha", 
	    new java.util.Date(1591056000000L)))), group("$sucursal.idSucursal", sum("Total venta", "$TotalVenta"))));
		
		MongoCursor<Document> it = result.iterator();
		while (it.hasNext()) {
			
			System.out.println(it.next().toJson());
		}
		
	}
}



