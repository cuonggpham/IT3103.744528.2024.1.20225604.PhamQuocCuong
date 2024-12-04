// Pham Quoc Cuong - 20225604
package src.hust.soict.dsai.aims.store;

import java.util.ArrayList;
import src.hust.soict.dsai.aims.media.Media;

public class Store {
    // List of Media items in Store
    private ArrayList<Media> itemsInStore = new ArrayList<>(); 

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    // Add a Media item to the store
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("CuongPQ 5604 - '" + media.getTitle() + "' has been added to the store!");
        } else {
            System.out.println("CuongPQ 5604 - '" + media.getTitle() + "' already exists in the store!");
        }
    }

    // Remove a Media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("CuongPQ 5604 - '" + media.getTitle() + "' has been removed from the store!");
        } else {
            System.out.println("CuongPQ 5604 - There is no '" + media.getTitle() + "' in the store!");
        }
    }

    // Search by ID method
    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media != null && media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    // Search by title method
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media != null && media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    // Print all items in the store
    public void printStore() {
        System.out.println("*************** STORE ****************");
        if (itemsInStore.isEmpty()) {
            System.out.println("CuongPQ 5604 - The store is currently empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println("CuongPQ 5604 - " + (i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("**************************************");
    }
}
