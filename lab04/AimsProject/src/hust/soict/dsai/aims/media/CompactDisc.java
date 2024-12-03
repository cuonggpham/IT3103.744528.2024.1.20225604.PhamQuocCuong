package src.hust.soict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // Constructor
    public CompactDisc(String artist) {
        super();
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    // Getter for artist
    public String getArtist() {
        return artist;
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
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
}
