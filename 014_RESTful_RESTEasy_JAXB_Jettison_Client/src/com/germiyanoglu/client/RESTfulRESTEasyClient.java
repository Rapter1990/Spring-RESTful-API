package com.germiyanoglu.client;

import javax.management.RuntimeErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.germiyanoglu.ogrenci.Ogrenci;

public class RESTfulRESTEasyClient {
	
	public static void main(String[] args) {
		// XMLElement
		String ogrenci1 = "{\"ogrenci\":{\"adi\":\"Sercan Noyan\",\"id\":1,\"soyadi\":\"Germiyanoðlu\",\"yasi\":28}}";
		String ogrenci2 = "{\"ogrenci\":{\"adi\":\"Burak\",\"id\":3,\"soyadi\":\"Acartürk\",\"yasi\":24}}";
		
		// XMLAttribute
		//String ogrenci1 = "{\"ogrenci\":{\"adi\":\"Sercan Noyan\",\"@id\":1,\"soyadi\":\"Germiyanoðlu\",\"yasi\":28}}";
		//String ogrenci2 = "{\"ogrenci\":{\"adi\":\"Burak\",\"@id\":3,\"soyadi\":\"Acartürk\",\"yasi\":24}}";
		
		Ogrenci ogrenci3 = new Ogrenci(4, "Hasan", "Çakýr", 30);
		
		try {
			
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/ogrenci/gonder");
			Response response = target.request().post(Entity.entity(ogrenci1, "application/json;charset=utF-8"));
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("HATA : HTTP STATUS CODE :" + response.getStatus());
			}
			
			System.out.println(response.readEntity(String.class)); // toString methodu çaðýrýr.
			
			System.out.println("-------------------------------------");
			
			
			
			
			response = target.request().post(Entity.entity(ogrenci2, "application/json;charset=utF-8"));
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("HATA : HTTP STATUS CODE :" + response.getStatus());
			}
			
			System.out.println(response.readEntity(String.class));
			
			System.out.println("-------------------------------------");			
			
			
			
			
			response = target.request().post(Entity.entity(ogrenci3, "application/json;charset=utF-8"));
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("HATA : HTTP STATUS CODE :" + response.getStatus());
			}
			
			System.out.println(response.readEntity(String.class));
			
			System.out.println("-------------------------------------");			
					
			
			response.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
