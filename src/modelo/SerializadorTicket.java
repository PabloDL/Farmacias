package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializadorTicket {
	
	public void debeDevolverLaRepresentacionJSONDeUnObjeto(Ticket t) {

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String ticketToJson = prettyGson.toJson(t);
		System.out.print(ticketToJson);
	}

	private void assertEquals(String string, String representacionJSON) {
		// TODO Auto-generated method stub
		
	}
}
