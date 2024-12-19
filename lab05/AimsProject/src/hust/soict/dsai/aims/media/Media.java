//Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    // Pham Quoc Cuong - 20225604
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Constructor
    public Media() {
        super();
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public Media(String title, String category, float cost) {
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
        this.id = ++nbMedia;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    } 

    public boolean isMatch(String title) {
		return this.getTitle().equalsIgnoreCase(title);
	}

    //Pham Quoc Cuong - 20225604
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // Check if the references are the same
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // Check if obj is null or not the same class
            return false;
        }
        Media media = (Media) obj; // Cast obj to Media
        return title != null && title.equals(media.title); // Compare titles
    }

    //Pham Quoc Cuong - 20225604
    @Override
    public String toString() {
        return "Media {id=" + id 
                    + ", title:'" + title + "\'"
                    + ", category: " + category + "\'"
                    + ", cost: $" + cost + "}";
    }
}
