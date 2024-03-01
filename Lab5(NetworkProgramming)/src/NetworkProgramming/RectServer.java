package NetworkProgramming;

import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.net.ServerSocket; 
import java.net.Socket; 
public class RectServer { 
    public static void main(String[] args) { 
        try (ServerSocket serverSocket = new ServerSocket(23456)) { 
            System.out.println("Server is listening on port 23456..."); 
            while (true) { 
                try (Socket clientSocket = serverSocket.accept(); 
                    ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream()); 
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) { 
                    
                    // Receive length and breadth from client 
                    double length = ois.readDouble(); 
                    double breadth = ois.readDouble(); 
                    System.out.println("Received length from client: " + length); 
                    System.out.println("Received breadth from client: " + breadth); 
                    
                    // Calculate area 
                    double area = length * breadth; 
                    // Send computed area back to the client 
                    oos.writeDouble(area); 
                    oos.flush(); 
                    System.out.println("Computed area sent to client: " + area); 
                } 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
}
