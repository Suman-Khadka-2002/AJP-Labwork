package lab1package;

import java.io.*;

public class Qn17_Readlinebyline {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Courses\\7th Sem\\Advance Java\\JavaProgram\\input1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}