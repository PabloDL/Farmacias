package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializadorTicket {
	
	public String debeDevolverLaRepresentacionJSONDeUnObjeto(Ticket t) {

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String ticketToJson = prettyGson.toJson(t);
		
		//Devuelvo json con ticket
		return ticketToJson;
	}

	private void assertEquals(String string, String representacionJSON) {
		// TODO Auto-generated method stub
		
	}
}
