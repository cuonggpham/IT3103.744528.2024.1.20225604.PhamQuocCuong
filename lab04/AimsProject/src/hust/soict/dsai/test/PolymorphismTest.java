// Pham Quoc Cuong - 20225604
package src.hust.soict.dsai.test;

import java.util.ArrayList;
import java.util.List;

import src.hust.soict.dsai.aims.media.Book;
import src.hust.soict.dsai.aims.media.CompactDisc;
import src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import src.hust.soict.dsai.aims.media.Media;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<>();

        CompactDisc cd = new CompactDisc("CD1");
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD1");
        Book book = new Book("Book1");

        media.add(cd);
        media.add(book);
        media.add(dvd);

        for(Media m : media) {
            System.out.println(m.toString());
        }
    }
}