package javaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
// ******************************************
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIo {

	public static void main(String[] args) {
		String path = "C:/Users/marco/eclipse-workspace/javaBase/arquivos/teste.txt";
		

//		escreveFile(path, "Passando String para ser escrita");
		lerFileReader(path);
	}
	
	public static void lerFileIputStream(String path) {
		try {
			FileInputStream fileInput = new FileInputStream(path);
			InputStreamReader read = new InputStreamReader(fileInput);
			BufferedReader bReader = new BufferedReader(read);			
			String line = bReader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = bReader.readLine();
				
			}
			
			
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void lerFileReader(String path) {
		try {
			File file = new File(path);
			FileReader fileReader = new FileReader(file);	
			BufferedReader	bfReader = new BufferedReader(fileReader);	
			String line = bfReader.readLine();		
			

			for (String i = ""; i != null; i = line ) {
				System.out.println(line);
				line = bfReader.readLine();
			}
			
			bfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void escreveFile(String path, String write) {
		try {
					FileWriter fileWreter = new FileWriter(path, true);
					fileWreter.append("\n"+write);
					
					fileWreter.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void lerFile(String path) {
		Path pathFile = Paths.get(path);
		
		try {
			List<String> linhasArquivos = Files.readAllLines(pathFile);
			for (String linha : linhasArquivos) {
				System.out.println(linha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
