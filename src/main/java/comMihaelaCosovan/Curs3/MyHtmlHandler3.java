package comMihaelaCosovan.Curs3;

import java.awt.Shape;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandler3 implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {

		//set headers and statur code
		String Export;
		
		String response = "<html><body><p>";
		
		 if (t.getRequestURI().getQuery() == null) { 
	        	System.out.println("No selection"); }
	        else {
	        	ShapeSide ss = new ShapeSide();
	        	String shape = t.getRequestURI().getQuery().split("=")[1];
	        	
	        	switch (shape)
	        	{
	        	case "Shape3": response += ss.getAvailableShapes(GeometricShape.Shape3).toString(); break;
	        	case "Shape4": response += ss.getAvailableShapes(GeometricShape.Shape4).toString(); break;
	        	case "Shape5": response += ss.getAvailableShapes(GeometricShape.Shape5).toString(); break;
	        	default: response = "";
	        	}
	        	
	        	
	        	//response += "</p></body></html>";
	        	response += "\n\n<a href=\"http://localhost:8001/html4\""
	        			+ t.getRequestURI().getQuery()
	        			+ "</a>\n<h3>Click here to see your options:</h3></p></body></html>";
	        	
	        	BufferedWriter bfwriter = new BufferedWriter(new FileWriter("C:\\MihaelaMacovei_Folder\\java.txt"));
	        	bfwriter.write(response);
	        	bfwriter.close();
	        	
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		
		//send response
		os.write(response.getBytes());
		
		//close request
		os.close();
		
		
				
	}}}
