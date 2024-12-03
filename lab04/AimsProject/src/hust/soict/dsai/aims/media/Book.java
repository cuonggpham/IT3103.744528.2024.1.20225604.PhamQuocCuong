package src.hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("CuongPQ 5604 : Author was added successfully");
        }
        else {
            System.out.println("CuongPQ 5604 : Author already exist");
        }
    }

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
}
