// Pham Quoc Cuong - 20225604 
package src.hust.soict.dsai.aims.cart;

import src.hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    // ArrayList to store ordered Media items
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

    // Method to add a Media item to the list
    public int addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("CuongPQ 5604 : The cart is almost full!");
            return 0;
        } else {
            itemsOrdered.add(media);
            System.out.println("CuongPQ 5604 : The item '" + media.getTitle() + "' has been added!");
            return 1;
        }
    }

    // Method to remove a Media item from the list
    public int removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("CuongPQ 5604 : Removed item '" + media.getTitle() + "' successfully!");
            return 1;
        } else {
            System.err.println("CuongPQ 5604 : No matching item found!");
            return 0;
        }
    }

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
        float sum = 0.00f;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    // Display items in the cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }

    // Search by ID method
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media != null && media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    // Search by title method
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media != null && media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    public int getNumItemsInCart() {
        return itemsOrdered.size();
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }
}
