package comMihaelaCosovan.Curs3;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

/**
 * Hello world!
 *
 */
//@SuppressWarnings("restriction")
public class App 
{
	public static void main( String[] args ) throws IOException
    {
		 //create weserver service
        HttpServer server = HttpServer.create(new InetSocketAddress(8001),0);
        
        //set handler to specified path
        server.createContext("/", new MyStringHandler());
        server.createContext("/html", new MyHtmlHandler());
        server.createContext("/html2", new MyHtmlHandler2());
        server.createContext("/html3", new MyHtmlHandler3());
        server.createContext("/html4", new MyHtmlHandler4());
        
        //creates a default executor
        server.setExecutor(null);
        
        //start the server
        server.start();
        System.out.println("***** Server Strated on port 8001 *****\n");
    }
}

