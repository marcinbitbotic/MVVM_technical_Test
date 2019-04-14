package com.mpogorzelski.app.technical_test;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.xml.sax.Parser;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by mpogorzelskil on 13/04/2019.
 */

public class JsonParser<Model> {
	
	private final Type clazz;
	private final Gson gson;
	
	public JsonParser(Gson gson, Type clazz) {
		this.gson = gson;
		this.clazz = clazz;
	}
	
	public Model deserialize(String data) throws IOException {
		try {
			return gson.fromJson(data, clazz);
		} catch (JsonSyntaxException e) {
			throw new IOException(e.getCause());
		}
	}
	
	public String serialize(Model model) {
		return gson.toJson(model);
	}
	
}
