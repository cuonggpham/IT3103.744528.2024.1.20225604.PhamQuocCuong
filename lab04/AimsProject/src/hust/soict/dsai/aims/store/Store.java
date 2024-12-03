package src.hust.soict.dsai.aims.store;

import java.util.ArrayList;

import src.hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    // list of DVD in Store
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>(); // Dynamic list for flexibility

    // addDVD method
    private boolean checkDVD(DigitalVideoDisc disc) {
        for (DigitalVideoDisc digitalVideoDisc : itemsInStore) {
            if (digitalVideoDisc.equals(disc)) {
                return true;
            }
        }
        return false;
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if(checkDVD(disc)) {
            itemsInStore.remove(disc);
            System.out.println("CuongPQ 5604 - " + disc.getTitle() + " 've been deleted from the store !");
        } else {
            System.out.println("CuongPQ 5604 - There is no "+ disc.getTitle() + " in the store !");
        }
    }

    public void addDVD(DigitalVideoDisc disc) {
        if(!checkDVD(disc)) {
            itemsInStore.add(disc);
            System.out.println("CuongPQ 5604 - " + disc.getTitle() + " 've been added to the store !");
        } else {
            System.out.println("CuongPQ 5604 - " + disc.getTitle() + " 'already exists in the store !");
        }

    }

    // print DVD in Store
    public void printStore() {
        System.out.println("***************STORE****************");
        if (itemsInStore.isEmpty()) {
            System.out.println("CuongPQ 5604 - The store is currently empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println("CuongPQ 5604 - " + (i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("************************************");
    }
}
