// Pham Quoc Cuong - 20225604 

package cuongpq;

public class DigitalVideoDisc {
    // Static variable to keep track of the number of discs created
    private static int nbDigitalVideoDiscs = 0; 
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id; // Unique identifier for each DVD

    //Constructor by title
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
    }
    // Constructor by category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
    }
    // Constructor by director, category, title and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
    }
    // Constructor by all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs; // Assign unique ID
    }

    //Getter
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
}
