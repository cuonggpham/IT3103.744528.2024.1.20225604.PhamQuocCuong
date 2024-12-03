package Exercise.JavaBasics.src;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null, "Pham Quoc Cuong - 5604 - Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "Pham Quoc Cuong - 5604 - You've chosen: "
        + (option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}
