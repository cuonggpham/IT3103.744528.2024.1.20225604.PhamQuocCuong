package src.hust.soict.dsai.test.store;

import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import src.hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[]  args){
		//Creat a new cart
		Store store = new Store();
		// Create new dvd object and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
        store.addDVD(dvd1); 
        store.addDVD(dvd2); 
        store.addDVD(dvd3);

        store.printStore();

        store.removeDVD(dvd3); 
        store.removeDVD(dvd2); 
        store.removeDVD(dvd1); 

        store.printStore();
    } 
}
