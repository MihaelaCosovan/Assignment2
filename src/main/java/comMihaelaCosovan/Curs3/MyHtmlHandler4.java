package comMihaelaCosovan.Curs3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyHtmlHandler4 implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		
		    	 
		
		//set the response as a string containing HTML code
		String response = "<html><body><h3>Data has been exported.\n</h3></body></html>"
				+ "<p><a href=\"http://localhost:8001/html\"><h4>Go to Home page!</h4></a></p>"
				+ "or"
				+ "<p><a href=\"http://localhost:8001/\"><h4>Leave my webpage!</h4></a></p>"
				+ "</body></html>";
		
			//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		
		//send response
		os.write(response.getBytes());
		
		//close request
		os.close();
	}
}