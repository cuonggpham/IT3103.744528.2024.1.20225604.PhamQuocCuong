// Example 4:
import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Pham Quoc Cuong - 5604 - You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "Pham Quoc Cuong - 5604 -Please input the first number: ", "Pham Quoc Cuong - 5604 -Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Pham Quoc Cuong - 5604 -Please input the second number: ", "Pham Quoc Cuong - 5604 -Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showMessageDialog(null, strNotification, "Pham Quoc Cuong - 5604 -Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
