// Pham Quoc Cuong - 20225604 
package src.hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Constructor by category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super();
    }
    // Constructor by director, category, title and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
    }
    // Constructor by all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
    }

    public DigitalVideoDisc(String title) {
        this.setTitle(title);
    }
    
    public String toString() {
        return  "Title='" + getTitle() + "\'" + 
                "Category='" + getCategory() + "\'" + 
                "Director='" + getDirector() + "\'" + 
                "Length='" + getLength() + "\'" + 
                "Cost='" + getCost() + "$" +"\'"; 
    } 

    public boolean isMatch(String title) {
		return this.getTitle().equalsIgnoreCase(title);
	}


    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());  
    }

    
}
