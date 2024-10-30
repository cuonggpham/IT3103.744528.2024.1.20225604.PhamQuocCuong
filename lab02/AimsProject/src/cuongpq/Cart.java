// Pham Quoc Cuong - 20225604 
package cuongpq;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    // Array to store ordered DVDs
    private DigitalVideoDisc itemOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered; // how many DigitalVideoDiscs in cart

    // Method to add an item to the list
    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered +1 > MAX_NUMBERS_ORDERED) {
            System.out.println("CuongPQ 5604 : The cast is almost full!");
            return 0;
        } else {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("CuongPQ 5604 : The DVD "+ "(" + qtyOrdered + ") " +"\'"+ disc.getTitle()+ "\'" +" have been added! ");
            return 1;
        }
    }

    // Method to remove an item from the list
    public int removeDigitalVideoDisc(DigitalVideoDisc disc){
        // Check if cart is empty
        if (qtyOrdered == 0) { 
            System.out.println("CuongPQ 5604 : Your cart is empty!");
            return 0;
        }
        // Find the disc in the array
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(disc)) { // Check if the DVD matches
                found = true;
                // Shift all items after the removed one to the left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                itemOrdered[qtyOrdered - 1] = null; // Clear the last item
                qtyOrdered--; // Reduce the number of items
                System.out.println("CuongPQ 5604 : Removed DVD '" + disc.getTitle() + "' successfully!");
                break;
            }
        }
        // If no matching DVD was found
        if (!found) {
            System.err.println("CuongPQ 5604 : No matching DVD found!");
            return 0;
        }
        return 1;
    }


    // Method to caculate the total cost DVDS in the cart
    public float totalCost() {
        float sum = 0.00f;
        for(int i=0; i<qtyOrdered; i++) {
            sum += itemOrdered[i].getCost();
        }
        return sum;
    }
}
