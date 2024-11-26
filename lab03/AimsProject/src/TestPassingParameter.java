// Pham Quoc Cuong - 20225604 

package src;
import src.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
	}

    // public static void swap(Object o1, Object o2) {
    //     Object tmp = o1;
    //     o1 = o2;
    //     o2 = tmp;
    // } 

    // Please write a swap() method that can correctly swap the two objects: 
    public static void swap(DigitalVideoDisc Object1, DigitalVideoDisc Object2) {
		DigitalVideoDisc tempObject = new DigitalVideoDisc(Object1.getTitle(), Object1.getCategory(), 
        Object1.getDirector(), Object1.getLength(), Object1.getCost()) ;

		Object1.setTitle(Object2.getTitle());    // gan title cua title 2 cho title 1
		Object1.setCategory(Object2.getCategory());    // gan Category cua Object2 cho Object1
		Object1.setDirector(Object2.getDirector());    // gan directory cua Object2 cho Object1
		Object1.setLength(Object2.getLength());    // gan lenght cua Object2 cho Object1
		Object1.setCost(Object2.getCost());    // gan cost cua Object2 cho Object1
		Object2.setTitle(tempObject.getTitle());
		Object2.setCategory(tempObject.getCategory());
		Object2.setDirector(tempObject.getDirector());
		Object2.setLength(tempObject.getLength());
		Object2.setCost(tempObject.getCost());
	}

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
