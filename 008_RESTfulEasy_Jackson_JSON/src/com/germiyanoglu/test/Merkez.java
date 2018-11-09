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


import com.germiyanoglu.modal.Kullanici;

public class Merkez {
	
	//http://localhost:8085/006_JAXB/kullanici/bilgi/1
	public static void main(String[] args){
		
		int id = 1;
		String urlText = "http://localhost:8085/008_RESTfulEasy_Jackson_JSON/kullanici/bilgi/" + id;
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
		} 
		
	}
}
