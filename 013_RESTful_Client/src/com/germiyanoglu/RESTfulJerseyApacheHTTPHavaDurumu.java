package com.germiyanoglu;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTfulJerseyApacheHTTPHavaDurumu {
	
	
	public static void main(String[] args) {
		
		RESTfulJerseyApacheHTTPHavaDurumu clientHavaDurumu = new RESTfulJerseyApacheHTTPHavaDurumu();
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
			
			String url = "http://localhost:8085/012_RESTful_Server/rest/ftoservice/json/" + fahrenheitTocelsius;
			
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet httpGetRequest = new HttpGet(url);
			httpGetRequest.addHeader("accept","application/json;charset=UTF-8");
			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
			
			
			
			if(httpResponse.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException(" GELEN HTTP CODE : " + httpResponse.getStatusLine().getStatusCode());
			}else {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
				String sonuc;
				
				while((sonuc = br.readLine()) != null) {
					System.out.println(sonuc);
				}
				
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
