// Pham Quoc Cuong - 20225604
// Main class
package src;

public class Aims {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",
                "Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star wars","Science Fiction",
                "Geogre Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);

        anOrder.addDigitalVideoDisc(dvd1); 
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("CuongPQ 5604 : The id of " + dvd1.getTitle() + " is " + dvd1.getId()); 
        System.out.println("CuongPQ 5604 : The id of " + dvd2.getTitle() + " is " + dvd2.getId());
        System.out.println("CuongPQ 5604 : The id of " + dvd3.getTitle() + " is " + dvd3.getId()); 

        System.out.printf("CuongPQ 5604 : Total cost is: %.2f",anOrder.totalCost());

    }
}
        // Add DVD array method
        // DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
        // anOrder.addDigitalVideoDisc(dvdList);

        // // Test when remove DVD 
        // System.out.println("------When remove DVD3:");
        // anOrder.removeDigitalVideoDisc(dvd3);
        // System.out.printf("CuongPQ 5604 : Total cost is: %.2f",anOrder.totalCost());
        // System.out.println();

        // System.out.println("------Remove when DVD not exist in cart:");
        // anOrder.removeDigitalVideoDisc(dvd3); // Test remove when DVD not exist 

        // System.out.println("------When remove DVD2:");
        // anOrder.removeDigitalVideoDisc(dvd2);
        // System.out.printf("CuongPQ 5604 : Total cost is: %.2f",anOrder.totalCost());
        // System.out.println();

        // System.out.println("------When remove DVD1:");
        // anOrder.removeDigitalVideoDisc(dvd1);
        // System.out.printf("CuongPQ 5604 : Total cost is: %.2f",anOrder.totalCost());
        // System.out.println();

        // System.out.println("------Remove when cart is empty:");
        // anOrder.removeDigitalVideoDisc(dvd1); // Test remove when cart is empty
//     }
// }
