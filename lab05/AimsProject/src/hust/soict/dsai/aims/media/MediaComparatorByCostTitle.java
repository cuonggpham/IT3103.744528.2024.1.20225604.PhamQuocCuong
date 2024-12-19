// Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if(o1.getCost() != o2.getCost()) {
            return (int) (o1.getCost() - o2.getCost());
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
