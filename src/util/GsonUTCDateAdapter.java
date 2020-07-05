package util;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

import org.bson.json.JsonParseException;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//this class can't be static
public class GsonUTCDateAdapter implements JsonSerializer<Date>,JsonDeserializer<Date> {

 private final DateFormat dateFormat;

 public GsonUTCDateAdapter() {
   dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");      //This is the format I need
   dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));                               //This is the key line which converts the date to UTC which cannot be accessed with the default serializer
   //System.out.print(dateFormat.format(new Date()).toString());
   
 }

 @Override public synchronized JsonElement serialize(Date date,Type type,JsonSerializationContext jsonSerializationContext) {
     return new JsonPrimitive(dateFormat.format(date));
 }

 @Override public synchronized Date deserialize(JsonElement jsonElement,Type type,JsonDeserializationContext jsonDeserializationContext) {
   try {
     return dateFormat.parse(jsonElement.getAsString());
   } catch (ParseException e) {
     throw new JsonParseException(e);
   }
 }
}