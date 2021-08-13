import java.io.*;
import java.net.*;
import java.util.Date;

/* A simple server class that initializes a port and detects client data
 * TCP/IP socket server
 * Specify port number so the server can listen to clients requests: Run ::   java TimeServer 6868
 * Used IntelliJ . Jdk 11.0.4
 * 5.23.20
 */

public class TimeServer {
    public static void main (String[] args){
        if (args.length < 1) return;
        int port = Integer.parseInt(args[0]);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("\n \n Server is listening on port " +port);   // Server

            while (true) {
                Socket socket = serverSocket.accept(); // Accepts sending and recieving data from client
                System.out.println("\n New client has been Connectedd.\n");
                OutputStream output = socket.getOutputStream(); 	// Stream that sends data to Client
                PrintWriter writer = new PrintWriter(output, true);	// Wraps data bytes to be sent as text

                writer.println("\n The Current Date is show below: \n");
             //   writer.println(new Date().toString());	// Date data being sent to Client
            } }

        catch (IOException ex){
            System.out.println("Server exception: " +ex.getMessage());
            ex.printStackTrace();
        }



    }
}

