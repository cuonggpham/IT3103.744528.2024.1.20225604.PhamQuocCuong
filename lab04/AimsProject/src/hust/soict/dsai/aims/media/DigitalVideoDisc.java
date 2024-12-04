// Pham Quoc Cuong - 20225604 
package src.hust.soict.dsai.aims.media;

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
    public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
        super(title, category,directory, length, cost);
    }
    
    // Pham Quoc Cuong - 20225604
    // Play Method
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());  
    }

    // Pham Quoc Cuong - 20225604
    @Override
    public String toString() {
        return "DVD - Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Cost: " + this.getCost();
    }
}


