//Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // Constructor
    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public CompactDisc(String title, String category, String director, ArrayList<Track> tracks, float cost) {
        super(title, category, director, cost);
        this.tracks = tracks;
        this.setLength(this.getLength());
    }
    public CompactDisc(String title, String artist, ArrayList<Track> tracks) {
        super(title);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String director, float length, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(int id, String title, String category, float cost,String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
        this.setLength(getLength());
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }


    // Methods to manage tracks
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("CuongPQ 5604 : Track already exist");
        } else {
            tracks.add(track);
            System.out.println("CuongPQ 5604 : The track " +"\'"+ track.getTitle()+ "\'" +" have been added! ");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("CuongPQ 5604 : The track " +"\'"+ track.getTitle()+ "\'" +" have been removed! ");
        } else {
            System.out.println("Track not found" );
        }
    }

    // Get total length of CD
    public float getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Pham Quoc Cuong - 20225604
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }

    // Pham Quoc Cuong - 20225604
    @Override
    public String toString() {
        return "CD - Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Artist: " + this.getArtist() + ", Cost: " + this.getCost();
    }
}
