package modelo;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.GsonUTCDateAdapter;

public class SerializadorTicket {
	
	public String debeDevolverLaRepresentacionJSONDeUnObjeto(Ticket t) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:SS.sss'Z'");
        						 //2020-07-01T00:14:31.000+00:00
		
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonUTCDateAdapter()).create();
	 
		 //System.out.println(gson.toJson(now));
		
		final String ticketToJson = gson.toJson(t);
		//Devuelvo json con ticket
		return ticketToJson;
	}

	private void assertEquals(String string, String representacionJSON) {
		// TODO Auto-generated method stub
		
	}
}
