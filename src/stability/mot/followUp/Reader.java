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
	
	private TombstonesArray tombstonesArray;
	
	public Reader() throws IOException {
		try {
			this.file = new File("C:\\Users\\Jefferson\\workspace\\StabilityProject\\src\\Results.txt");
			this.fileReader = new FileReader(file);
			this.reader =  new BufferedReader(fileReader);			
			tombstonesArray = new TombstonesArray();			
			readFile();			
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally{
			reader.close();	
		}
	}
	

	private void readFile() throws IOException {
		String line;boolean finishReading = false;
        try {
			while(((line = reader.readLine()) != null) && (!finishReading)){
			  System.out.println(line);
			  if(ANRsFound(line)){
				   readANRs();
			  }if(forceClosesFound(line)){
				  readForceCloses();
			  }if(tombstoneFound(line)){
				   readTombstones(); // Leitura de Tombstones do arquivo.
				   finishReading=true;
			  }if(panicsFound(line)){
				  readPanics();
			  }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
	private void readTombstones() throws IOException {
		int i = 0; String l;
		try {
			while(((l = reader.readLine()) != null) && (i<getTombstonesArray().getQuantity())){
				System.out.println(l);
				Tombstone tombstone = createTombstone(l); // Cria um objeto Tombstone a partir de uma linha do arquivo.
				tombstonesArray.addTombstone(tombstone);
				i++;
			}
		}catch (IOException e) {
			e.printStackTrace();
		}		
	}


	private Tombstone createTombstone(String l) {
		Tombstone tombstone = new Tombstone();
		tombstone.setLine(l); // linha do arquivo que representa o Tombstone.		
		String splitOne[] = l.split("-");		
		String directory = splitOne[0].trim().substring(2); // Diretorio do Tombstone.	
		directory = directory.replace('\\','/');		
		String directoriesStrings[] = directory.split("/");		
		String device = directoriesStrings[2]; // o fone(Dispositivo) correspondente, presente no diretorio.
		String report = directoriesStrings[3]; // o nome do report
		String testCase = directoriesStrings[5]; // o numero do testCase		
		tombstone.setDevice(device);
		tombstone.setReportName(report);
		tombstone.setTestCase(testCase);		
		tombstone.setDirectory(directory);
		String type = (String) splitOne[1].subSequence(0, splitOne[1].indexOf("("));//tipo do Tombstone;		
		tombstone.setTipo(type);		
		String secondSplit[] = splitOne[1].split(",");		
		String ThirdSplit[] = secondSplit[0].split(":");
		String pid = ThirdSplit[1].trim();// pid do Tombstone.
		tombstone.setPid(pid);		
		String fourthSplit[] = secondSplit[1].split(">>>");		
		String fifthSplit[] = fourthSplit[0].split(" ");		
		String tid = fifthSplit[2].trim(); // Tid do Tombstone.		
		tombstone.setTid(tid);			
		return tombstone;
	}


	private boolean tombstoneFound(String line) {
		int numberOfTombstone;
		if(line.startsWith("Tombstones")){
			System.out.println("Linha = " + line);
			String numberString[] = line.split(" ");
			String n = numberString[1].substring(1, numberString[1].length()-2);
			numberOfTombstone = Integer.parseInt(n);
			tombstonesArray.setQuantity(numberOfTombstone);
			return true;
		}		
		return false;
	}
	
	private void readANRs() {
		
	}


	private boolean ANRsFound(String line) {
		return false;
	}
	
	private void readPanics() {
		// TODO Auto-generated method stub
		
	}


	private boolean panicsFound(String line) {
		// TODO Auto-generated method stub
		return false;
	}


	private void readForceCloses() {
		// TODO Auto-generated method stub
		
	}


	private boolean forceClosesFound(String line) {
		// TODO Auto-generated method stub
		return false;
	}


	public TombstonesArray getTombstonesArray() {
		return tombstonesArray;
	}


	public void setTombstonesArray(TombstonesArray tombstonesArray) {
		this.tombstonesArray = tombstonesArray;
	}


	public BufferedReader getReader() {
		return reader;
	}
	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}	
}
