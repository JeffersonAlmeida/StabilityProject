package stability.mot.followUp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Reader {

	
	private BufferedReader reader;
	private FileReader fileReader;
	private File file;
	
	public Reader() throws FileNotFoundException {
		try {
			this.file = new File("C:\\Users\\Jefferson\\workspace\\StabilityProject\\src\\Results.txt");
			this.fileReader = new FileReader(file);
			this.reader =  new BufferedReader(fileReader);
		} catch (Exception e) {
			System.out.println(e.toString());
		}		
	}
	

	private void readFile() throws IOException {
		String line;
        try {
			while((line = reader.readLine()) != null){
			   System.out.println(line);
			   readTombstone(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        reader.close();		
	}


	private void readTombstone(String line) {
		int numberOfTombstone;
		if(line.startsWith("Tombstones")){
			System.out.println("Linha = " + line);
			String numberString[] = line.split(" ");
			String n = numberString[1].substring(1, numberString[1].length()-2);
			numberOfTombstone = Integer.parseInt(n);
			JOptionPane.showMessageDialog(null, "Linha = " + line + "number = " + numberOfTombstone);
		}		
	}


	public static void main(String[] args) throws FileNotFoundException{
		Reader reader = new Reader();
		try {
			reader.readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
