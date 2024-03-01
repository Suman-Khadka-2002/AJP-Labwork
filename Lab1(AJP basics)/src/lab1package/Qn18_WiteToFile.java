package lab1package;

import java.io.*;
import java.util.*;

public class Qn18_WiteToFile {
	public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter("D:\\Courses\\7th Sem\\Advance Java\\JavaProgram\\output.txt")) {
            String line;
            while (true) {
                System.out.print("Enter a line (type 'quit' to exit): ");
                line = scanner.nextLine();
                if (line.equals("quit")) {
                    break;
                }
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
