package NetworkProgramming;

import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.net.ServerSocket; 
import java.net.Socket; 

public class CircleServer { 
    public static void main(String[] args) { 
        try (ServerSocket serverSocket = new ServerSocket(12345)) { 
            System.out.println("Server is listening on port 12345..."); 
            while (true) { 
            try (Socket clientSocket = serverSocket.accept(); 
                ObjectInputStream ois= new ObjectInputStream(clientSocket.getInputStream()); 
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream()) ) { 
                
                    // Receive radius from client 
                    double radius = ois.readDouble(); 
                    System.out.println("Received radius from client: " + radius); 
                    
                    // Calculate area 
                    double area = Math.PI * Math.pow(radius, 2); 
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