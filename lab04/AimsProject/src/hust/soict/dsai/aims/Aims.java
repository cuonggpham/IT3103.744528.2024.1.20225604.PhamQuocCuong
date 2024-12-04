// Pham Quoc Cuong - 20225604
// Main class
package src.hust.soict.dsai.aims;

import java.util.*;

import src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Book;
import src.hust.soict.dsai.aims.media.CompactDisc;
import src.hust.soict.dsai.aims.media.Media;

public class Aims {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<>();

        CompactDisc cd = new CompactDisc("CD1");
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD1");
        Book book = new Book("Book1");

        media.add(cd);
        media.add(book);
        media.add(dvd);

        media.forEach(item -> System.out.println(item.toString()));
    }
}