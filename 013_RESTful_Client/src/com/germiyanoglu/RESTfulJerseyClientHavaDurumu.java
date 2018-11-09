package com.germiyanoglu;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTfulJerseyClientHavaDurumu {
	
	
	public static void main(String[] args) {
		
		RESTfulJerseyClientHavaDurumu clientHavaDurumu = new RESTfulJerseyClientHavaDurumu();
		Double celsiusToFahrenheit = 30.0;
		Double fahrenheitTocelsius = 30.0;
		System.out.println("--------------getFahrenheittoCelsiusJSON----------");
		clientHavaDurumu.getFahrenheittoCelsiusJSON(celsiusToFahrenheit);
		
		System.out.println("--------------getFahrenheittoCelsiusXML----------");
		clientHavaDurumu.getFahrenheittoCelsiusXML(celsiusToFahrenheit);
		
		System.out.println("--------------getFahrenheittoCelsiusJSON----------");
		clientHavaDurumu.getFahrenheittoCelsiusJSON(fahrenheitTocelsius);
		
		System.out.println("--------------getFahrenheittoCelsiusXML----------");
		clientHavaDurumu.getFahrenheittoCelsiusXML(fahrenheitTocelsius);
		
	}
	
	private void getFahrenheittoCelsiusJSON(Double fahrenheitTocelsius) {
		try {
			Client client = Client.create();
			String url = "http://localhost:8085/012_RESTful_Server/rest/ftoservice/json/" + fahrenheitTocelsius;
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.accept("application/json" + ";charset=UTF-8").get(ClientResponse.class);
			
			if(response.getStatus() != 200) {
				throw new RuntimeException(" GELEN HTTP CODE : " + response.getStatus());
			}else {
				String sonuc = response.getEntity(String.class);
				System.out.println(sonuc);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void getFahrenheittoCelsiusXML(Double fahrenheitTocelsius) {
		try {
			Client client = Client.create();
			String url = "http://localhost:8085/012_RESTful_Server/rest/ftoservice/xml/" + fahrenheitTocelsius;
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.accept("application/xml" + ";charset=UTF-8").get(ClientResponse.class);
			
			if(response.getStatus() != 200) {
				throw new RuntimeException(" GELEN HTTP CODE : " + response.getStatus());
			}else {
				String sonuc = response.getEntity(String.class);
				System.out.println(sonuc);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void getCelsiustoFahrenheitXML(Double celsiusToFahrenheit) {
		try {
			Client client = Client.create();
			String url = "http://localhost:8085/012_RESTful_Server/rest/ctoservice/xml/" + celsiusToFahrenheit;
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.accept("application/xml" + ";charset=UTF-8").get(ClientResponse.class);
			
			if(response.getStatus() != 200) {
				throw new RuntimeException(" GELEN HTTP CODE : " + response.getStatus());
			}else {
				String sonuc = response.getEntity(String.class);
				System.out.println(sonuc);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void getCelsiustoFahrenheitJSON(Double celsiusToFahrenheit) {
		try {
			Client client = Client.create();
			String url = "http://localhost:8085/012_RESTful_Server/rest/ctoservice/json" + celsiusToFahrenheit;
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.accept("application/json" + ";charset=UTF-8").get(ClientResponse.class);
			
			if(response.getStatus() != 200) {
				throw new RuntimeException(" GELEN HTTP CODE : " + response.getStatus());
			}else {
				String sonuc = response.getEntity(String.class);
				System.out.println(sonuc);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
