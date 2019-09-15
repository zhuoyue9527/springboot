package com.zhuo.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zhuo.entity.Area;
import com.zhuo.entity.People;

@JsonComponent
public class Example {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static SimpleDateFormat deserializeFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static class Serializer extends JsonSerializer<Date> {

		@Override
		public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
			System.out.println("serialize----");
			gen.writeString(dateFormat.format(value));
		}

		
	}

	public static class Deserializer extends JsonDeserializer<People> {

		@Override
		public People deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			System.out.println("deserialize----");
			return  null;
		}

		
	}
}
