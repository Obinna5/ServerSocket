import java.io.*;
import java.net.*;
import java.util.Date;

/* A simple Client class that outputs Date information
 * TCP/IP socket server
 * A Hostname needs to be specified as well as the port number of the server.
 * SERVER MUST BE RUNNING. If the client is on the same computer as the server:  java TimeClient localhost 6868
 * This would output the connection confirmation and date on the client side. A Client confirmation would be shown on the Server side.
 * 5.23.20
 */

public class TimeClient {
	public static void main(String[] args) {
		if (args.length < 2) return;
		String hostname = args[0];
		int port = Integer.parseInt(args[1]);

		try (Socket socket = new Socket(hostname, port)) {

			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			String time = reader.readLine();
			System.out.println("\n" +time);				// Outputs time from reader/port

		} catch (UnknownHostException ex) {
			System.out.println("\n Server not found: " +ex.getMessage());		// Can't Find Server
		}
		catch (IOException ex) {
			System.out.println("\n I/O Error: " +ex.getMessage());				// Wrong Input
		}


	}
}

