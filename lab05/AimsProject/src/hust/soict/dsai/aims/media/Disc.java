// Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private float length;
    private String director;

    // Pham Quoc Cuong - 20225604
    //Constructors
    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, String director, float length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    } 

    public Disc(int id, String title, String category, float cost, String director, float length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    } 
}

