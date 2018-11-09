package com.germiyanoglu;

import java.io.File;
import java.text.NumberFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.apache.log4j.Logger;


@Path("/files")
public class IndirDownloadServis {
	
	static Logger logger = Logger.getLogger(IndirDownloadServis.class);

	private static final String TXT_ADRES = "/Users/Noyan/Desktop/jersey_download.txt";
    									//  "C:\\Users\\Noyan\\Desktop\\jersey_download.txt";
	
	@GET
	@Path("/txt")
	@Produces ("text/plain")
	//@Produces ("image/png")
	//@Produces ("application/pdf")
	//@Produces ("application/vnd.ms-excel")
	public Response txtIndir() {
		
		File file = new File(TXT_ADRES);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"inendosya.txt\"");
		return response.build();
	}	
	
	private static final String PNG_ADRES = "/Users/Noyan/Desktop/jersey_download.png";
										//"C:\\Users\\Noyan\\Desktop\\jersey_download.txt";
	
	@GET
	@Path("/png")
	@Produces ("image/png")
	public Response pngIndir() {
		
		File file = new File(PNG_ADRES);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"inendosya.png\"");
		return response.build();
	}	
	
	@GET
	@Path("/pdf")
	@Produces ("application/pdf")
	public Response pdfIndir() {
		
		String PDF_ADRES = "/Users/Noyan/Desktop/jersey_download.pdf";
		//"C:\\Users\\Noyan\\Desktop\\jersey_download.txt";
		
		Response response = null;
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);

	    // Retrieve the file 
	    File file = new File(PDF_ADRES);
	    if (file.exists()) {

	      ResponseBuilder builder = Response.ok(file);
	      builder.header("Content-Disposition", "attachment; filename=\"inendosya.pdf\" ");
	      response = builder.build();
	      long file_size = file.length();
	            logger.info(String.format("Inside downloadFile==> fileName: %s, fileSize: %s bytes", 
	            		PDF_ADRES, myFormat.format(file_size)));
	    } else {

	      logger.error(String.format("Inside downloadFile==> FILE NOT FOUND: fileName: %s", 
	    		  PDF_ADRES));
	      response = Response.status(404).
	              entity("FILE NOT FOUND: " + PDF_ADRES).
	              type("text/plain").
	              build();
	    }

	    return response;

	}
	
}
