package com.germiyanoglu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

// http://localhost:8085/012_RESTful_Server/rest/ftoservice

@Path("/ftoservice")
public class FtoCService {

	// http://localhost:8085/012_RESTful_Server/rest/ftoservice
	@GET
	@Produces("application/json;charset=UTF-8")
	public Response cevirFtoC() {
		
		Double fahrenheit = 98.24;
		Double celsius;
		
		celsius = (fahrenheit - 32) * 5 / 9;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("F VALUE", fahrenheit);
		jsonObject.put("C VALUE", celsius);
		
		String sonuc = "F ---- > C \n" +jsonObject.toString();
		//String a = "@Produces(\"application/json;charset=UTF-8\") + jsonObject.toString()";
		
		return Response.status(200).entity(sonuc).build();
	}
	
	// http://localhost:8085/012_RESTful_Server/rest/ftoservice/json/10
	@GET
	@Path("/json/{fahrenheit}")
	@Produces("application/json;charset=UTF-8")
	public Response cevirFtoCDetayJSON(@PathParam("fahrenheit") Double fahrenheit) {
		
		//Double fahrenheit = 98.24;
		Double celsius;
		
		celsius = (fahrenheit - 32) * 5 / 9;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("F VALUE", fahrenheit);
		jsonObject.put("C VALUE", celsius);
		
		String sonuc = "F ---- > C \n" +jsonObject.toString();
		//String a = "@Produces(\"application/json;charset=UTF-8\") + jsonObject.toString()";
		
		return Response.status(200).entity(sonuc).build();
	}
	
	// http://localhost:8085/012_RESTful_Server/rest/ftoservice/xml/10
	@GET
	@Path("/xml/{fahrenheit}")
	@Produces("application/xml;charset=UTF-8")
	public Response cevirFtoCDetayXML(@PathParam("fahrenheit") Double fahrenheit) {
		
		//Double fahrenheit = 98.24;
		Double celsius;
		
		celsius = (fahrenheit - 32) * 5 / 9;
		
		String sonuc = "<ctofservice> "
	              + " <celsius> " + celsius + " </celsius> "
	              + "<ctoservice> " + fahrenheit + " </ctoservice>"
			+ " </ctofservice>";
		
		return Response.status(200).entity(sonuc).build();
	}
}
