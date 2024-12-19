// Pham Quoc Cuong - 20225604
package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[]  args){
		//Creat a new cart
		Store store = new Store();
		// Create new dvd object and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "Roger Allers", "The Lion King", 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", "George Lucas", "Star Wars", 24.95f);
		
        store.addMedia(dvd1); 
        store.addMedia(dvd2); 

        store.printStore();

        store.removeMedia(dvd2); 
        store.removeMedia(dvd1); 

        store.printStore();
    } 
}
