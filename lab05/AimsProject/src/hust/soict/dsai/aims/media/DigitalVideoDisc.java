// Pham Quoc Cuong - 20225604 
package hust.soict.dsai.aims.media; 
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    // Constructors
    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String directory, float cost) {
        super(title, category, directory, cost);
    }
    public DigitalVideoDisc(String title, String category, String directory, float length, float cost) {
        super(title, category,directory, length, cost);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost, String director, float length) {
        super(id, title, category, cost, director, length);
    }

    public  DigitalVideoDisc(int id, String title, String category, float cost){
        super(id,title,category,cost);
    }
    
    // Pham Quoc Cuong - 20225604
    @Override
    public String toString() {
        return "DVD - Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Cost: " + this.getCost();
    } 

    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }
}


