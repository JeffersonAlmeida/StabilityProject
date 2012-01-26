package stability.mot.followUp;

import java.util.ArrayList;
import java.util.Iterator;

public class TombstonesArray {
	
	private ArrayList<Tombstone> tombstonesList;
	private int quantity;
	
	
	public TombstonesArray() {
		this.setTombstonesList(new ArrayList<Tombstone>());
		this.setQuantity(0) ;
	}
	
	public void addTombstone(Tombstone t){
		this.tombstonesList.add(t);
	}
	
	public void removeTombstone(Tombstone t){
		this.tombstonesList.remove(t);
	}

	public ArrayList<Tombstone> getTombstonesList() {
		return tombstonesList;
	}

	public void setTombstonesList(ArrayList<Tombstone> tombstonesList) {
		this.tombstonesList = tombstonesList;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void showTombstones(){
		Iterator<Tombstone> i = this.tombstonesList.iterator();
		while (i.hasNext()) {
			Tombstone tombstone = (Tombstone) i.next();
			System.out.println(tombstone.toString());
		}
	}
}
