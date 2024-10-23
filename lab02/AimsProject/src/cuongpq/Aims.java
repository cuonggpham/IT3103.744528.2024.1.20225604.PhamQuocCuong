// Pham Quoc Cuong - 20225604
// Main class

package cuongpq;

public class Aims {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",
                "Roger Allers",87,19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star wars","Science Fiction",
                "Geogre Lucas",87,24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // Test when haven't been removed
        System.out.printf("Total cost is: %.2f",anOrder.totalCost());
        System.out.println();

        // Test when removed
        anOrder.removeDigitalVideoDisc(dvd1);
        System.out.printf("Total cost is: %.2f",anOrder.totalCost());
        System.out.println();

        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.printf("Total cost is: %.2f",anOrder.totalCost());
        System.out.println();

        anOrder.removeDigitalVideoDisc(dvd1);
        System.out.printf("Total cost is: %.2f",anOrder.totalCost());
        System.out.println(); 

        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.printf("Total cost is: %.2f",anOrder.totalCost());
        System.out.println();

        anOrder.removeDigitalVideoDisc(dvd1);
        System.out.printf("Total cost is: %.2f",anOrder.totalCost());
        System.out.println();
    }
}
