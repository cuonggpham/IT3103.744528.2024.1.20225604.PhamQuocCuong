// Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Pham Quoc Cuong - 20225604
    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    // Pham Quoc Cuong - 20225604
    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    // Pham Quoc Cuong - 20225604
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // Check if the references are the same
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // Check if obj is null or not the same class
            return false;
        }
        Track track = (Track) obj; // Cast obj to Track
        return length == track.length && (title != null && title.equals(track.title)); // Compare title and length
    }

}
