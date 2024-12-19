//Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    //Constructor
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(String title) {
        super(title);
    }
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    //add Author method
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("CuongPQ 5604 : Author was added successfully");
        }
        else {
            System.out.println("CuongPQ 5604 : Author already exist");
        }
    }

    // remove Author method
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("CuongPQ 5604 : Removed author successfully");
        } else {
            System.out.println("CuongPQ 5604 : Author not found");
        }   
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    } 

    // Pham Quoc Cuong - 20225604
    @Override
    public String toString() {
        return "Book - Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Cost: " + this.getCost();
    }
}
