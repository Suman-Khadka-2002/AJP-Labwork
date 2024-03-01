package NetworkProgramming;

import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.net.Socket; 
import java.util.Scanner; 

public class RectClient { 
    public static void main(String[] args) { 
        try (Scanner scanner = new Scanner(System.in); 
            Socket socket = new Socket("localhost", 23456); 
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()); 
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) { 
            
            // Get length and breadth from user 
            System.out.print("Enter the length of the rectangle: "); 
            double length = scanner.nextDouble(); 
            System.out.print("Enter the breadth of the rectangle: "); 
            double breadth = scanner.nextDouble(); 
            
            // Send length and breadth to the server 
            oos.writeDouble(length); 
            oos.writeDouble(breadth); 
            oos.flush(); 
            System.out.println("Length and breadth sent to server."); 
            
            // Receive computed area from the server 
            double area = ois.readDouble(); 
            System.out.println("Received computed area from server: " + area); 
            // Display the result 
            System.out.println("The area of the rectangle with length " + length + 
            " and breadth " + breadth + " is: " + area); 
        } catch (IOException e) { 
                e.printStackTrace(); 
            }
    }
} 