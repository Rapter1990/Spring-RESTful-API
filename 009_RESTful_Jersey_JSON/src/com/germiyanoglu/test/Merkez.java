package com.germiyanoglu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



public class Merkez {
	
	//http://localhost:8085/006_JAXB/kullanici/bilgi/1
	public static void main(String[] args){
		int id = 1;
		String url = "http://localhost:8085/009_RESTful_Jersey_JSON/kayit/bilgi/" + id;
		try {
			Client client = Client.create();
			WebResource resource = client.resource(url);
			ClientResponse response = resource.accept("application/json" + ";charset=UTF-8").get(ClientResponse.class);
			
			if(response.getStatus() != 200) {
				throw new RuntimeException(" GELEN HTTP CODE : " + response.getStatus());
			}else {
				String sonuc = response.getEntity(String.class);
				System.out.println(sonuc);
				
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		/*int id = 1;
		String urlText = "http://localhost:8085/009_RESTful_Jersey_JSON/kayit/bilgi/" + id;
		try {
			URL url = new URL(urlText);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json" + ";charset=UTF-8");
			
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException(" GELEN HTTP CODE : " + connection.getResponseCode());
			}
			
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String sonuc = bufferedReader.readLine();
			System.out.println(sonuc);
			connection.disconnect();
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} */
		
	}
}
