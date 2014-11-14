/**
 * @author Marcos Vinicius Berté
 *
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reader {
	private String[] lines;
	
	public Reader() {
		
	}

	public String[] readFile(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String code = "";
		String aux = br.readLine();
		while (aux != null) {
			code += aux + ";";
			aux = br.readLine();
		}
		br.close();
		lines = code.split(";");
		return lines;
	}

	public void writeFile(String content, File file) {
		try {
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Print Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
