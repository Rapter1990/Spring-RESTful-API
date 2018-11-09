package com.germiyanoglu.ws.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MusteriRESTfulClient {

public static void main(String[] args) {
		
		
		try {
			Client client = Client.create();
			String url = "http://localhost:8085/017_RESTful_Multiple_Output_Format_JDBC_CRUD/rest/musteri/herkes";
			WebResource webResource = client.resource(url);
			
			// JSON olarak veriyi getirir
			//ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			
			// XML olarak veriyi getirir
			ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
		
			if (response.getStatus() == 200) {
				
				System.out.println(response.getEntity(String.class));
		
			}else{
				System.out.println("HATA MEYDANA GELDÝ. : HTTP STATUS CODE: " + response.getStatus());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
