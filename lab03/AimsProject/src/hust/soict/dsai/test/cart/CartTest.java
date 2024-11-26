// Pham Quoc Cuong - 20225604
package src.hust.soict.dsai.test.cart;

import src.hust.soict.dsai.aims.cart.Cart;
import src.hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[]  args){
		//Creat a new cart
		Cart cart = new Cart();
		// Create new dvd object and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		
		cart.printCart(); 

        
        // search by ID 
        int searchId = 3;
        DigitalVideoDisc foundById = cart.searchById(searchId);
        if (foundById != null) {
            System.out.println("CuongPQ 5604 - Found by ID: " + searchId + " --- " + foundById.toString());
        }
        else {
            System.out.println("CuongPQ 5604 - No DVD with ID: " + searchId); 
        }


        // search by title 
        String searchTitle = "star wars";
        DigitalVideoDisc foundByTitle = cart.searchByTitle(searchTitle);
        if (foundByTitle != null) {
            System.out.println("CuongPQ 5604 - Found by Title: " + searchTitle + " --- " + foundByTitle.toString());
        }
        else {
            System.out.println("CuongPQ 5604 - No DVD with Title: " + searchTitle); 
        }
	}
}
