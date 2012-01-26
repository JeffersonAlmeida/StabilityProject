package stability.mot.followUp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Cliente {

	
	public static void main(String[] args) throws IOException {
		
		Reader reader = new Reader();
		TombstonesArray tombstonesArray = reader.getTombstonesArray();
		tombstonesArray.showTombstones();
		
		System.out.println("\n\nQuantity: " + tombstonesArray.getQuantity() + " Confere quantity: " + tombstonesArray.getTombstonesList().size());

	}

}
