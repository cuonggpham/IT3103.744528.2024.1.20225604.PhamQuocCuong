// Pham Quoc Cuong - 20225604 
package src;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0; //class variable
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost; 
    private int id;

    //Constructor by title
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }
    // Constructor by category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
    // Constructor by director, category, title and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
    // Constructor by all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
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
    public int getId() {
        return id;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setCost(float cost) {
        this.cost = cost;
    } 

    public String toString() {
        return  "Title='" + title + "\'" + 
                "Category='" + category + "\'" + 
                "Director='" + director + "\'" + 
                "Length='" + length + "\'" + 
                "Cost='" + cost + "$" +"\'"; 
    } 

    public boolean isMatch(String title) {
		return this.title.equalsIgnoreCase(title);
	}
}
