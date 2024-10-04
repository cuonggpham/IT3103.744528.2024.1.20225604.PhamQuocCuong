//Example 3:
import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("CuongPQ - 5604 - Please enter your name:");
        JOptionPane.showMessageDialog(null, "I'm Pham Quoc Cuong - 5604 - Hi "+ result + "!");
        System.exit(0);
    }
}
