package lab1package;

import java.io.*;

public class Qn14_ReadWriteFile {

	public static void main(String[] args) throws IOException {
//		creating FileInputStream object
		File file = new File("D:\\Courses\\7th Sem\\Advance Java\\JavaProgram\\myfile.txt");
		FileInputStream fis = new FileInputStream(file);
		
		byte bytes[] = new byte[(int) file.length()];
		
//		reading data from the file
		fis.read(bytes);
		fis.close();
		
//		writing data to another file
		File out = new File("D:\\Courses\\7th Sem\\Advance Java\\JavaProgram\\copyofmyfile.txt");
		
		FileOutputStream fos = new FileOutputStream(out);
		
//		writing data to the file
		fos.write(bytes);
		fos.close();
		fos.flush();
		System.out.println("Data successfully written in the specified file");
	}

}
