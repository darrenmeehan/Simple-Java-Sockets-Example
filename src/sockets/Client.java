package sockets;

import java.io.*;
import java.net.*;

/**
 *
 * @author darren
 */
public class Client {

    public static void main(String arg[]) throws IOException {

        int portNum = 11112;

        Socket socket = new Socket("localhost", portNum);

        // Integer Object to send to Server.
        Integer num = new Integer(50);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        out.writeObject(num);
        
        char res = in.readChar();
        
        System.out.println("Response from Server received: " + res);
        
    }
}
