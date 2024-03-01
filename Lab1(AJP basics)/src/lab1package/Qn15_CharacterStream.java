package lab1package;

import java.io.*;

public class Qn15_CharacterStream {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("D:\\Courses\\7th Sem\\Advance Java\\JavaProgram\\myfile.txt");
	             FileWriter writer = new FileWriter("D:\\Courses\\7th Sem\\Advance Java\\JavaProgram\\copyofmyfile.txt")) {
	            int c;
	            while ((c = reader.read()) != -1) {
	                writer.write(c);
	                writer.write(c);
	            }
	            System.out.println("Successfully done!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

}
