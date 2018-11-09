package com.germiyanoglu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;


//http://localhost:8085/012_RESTful_Server/rest/ctoservice

@Path("/ctoservice")
public class CtoFService {

	// http://localhost:8085/012_RESTful_Server/rest/ctoservice
		@GET
		@Produces("application/xml")
		public Response cevirCtoF() {
			
			Double fahrenheit;
			Double celsius = 10.50;
			
			fahrenheit = ((celsius * 9) / 5 ) + 32;
			
			
			String sonuc = "<ctofservice> "
					              + " <celsius> " + celsius + " </celsius> "
					              + "<ctoservice> " + fahrenheit + " </ctoservice>"
							+ " </ctofservice>";
			//String a = "@Produces(\"application/json;charset=UTF-8\") + jsonObject.toString()";
			
			return Response.status(200).entity(sonuc).build();
		}
		
		// http://localhost:8085/012_RESTful_Server/rest/ctoservice/xml/10
		@GET
		@Path("/xml/{celsius}")
		@Produces("application/xml")
		public Response cevirCtoFDetayXML(@PathParam("celsius") Double celsius) {
			
			Double fahrenheit;
			
			fahrenheit = ((celsius * 9) / 5 ) + 32;
			
			String sonuc = "<ctofservice> "
		              + " <celsius> " + celsius + " </celsius> "
		              + "<ctoservice> " + fahrenheit + " </ctoservice>"
				+ " </ctofservice>";
			
			return Response.status(200).entity(sonuc).build();
		}
		
		
		// http://localhost:8085/012_RESTful_Server/rest/ctoservice/json/10
		@GET
		@Path("/json/{celsius}")
		@Produces("application/json")
		public Response cevirCtoFDetayJSON(@PathParam("celsius") Double celsius) {
			
			Double fahrenheit;
			
			fahrenheit = ((celsius * 9) / 5 ) + 32;
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("F VALUE", fahrenheit);
			jsonObject.put("C VALUE", celsius);
			
			String sonuc = "F ---- > C \n" +jsonObject.toString();
			//String a = "@Produces(\"application/json;charset=UTF-8\") + jsonObject.toString()";
			
			return Response.status(200).entity(sonuc).build();
		}
}
