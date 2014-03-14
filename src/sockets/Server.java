package sockets;

// Keeping imports easy to remember.
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Port number to bind server to.
        int portNum = 11113;
        
        // Socket for server to listen at.
        ServerSocket listener = new ServerSocket(portNum);

        System.out.println("Server is now running at port: " + portNum);

        // Simply making Server run continously.
        while (true) {
            try {
                // Accept a client connection once Server recieves one.
                Socket clientSocket = listener.accept();

                // Creating inout and output streams. Must creat out put stream first.
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                // Reading in Integer Object from input stream.
                int i = (Integer) in.readObject();

                //Sending response back to client
                String response = "Integer Object Received.";
                out.writeObject(response);

                // Outputting recieved Integer Object.
                System.out.println("Received integer: " + i);
                out.close();
                in.close();
                clientSocket.close();
                break;
            } finally {
                      // Closing Server Socket now.
                      listener.close();
               
            }
            
             
                
        }
    }

}
