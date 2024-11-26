// package lab01;

import javax.swing.JOptionPane;

public class Bai5 {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Pham Quoc Cuong - 5604 - Enter the first number:");
        String strNum2 = JOptionPane.showInputDialog("Pham Quoc Cuong - 5604 - Enter the second number:");

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        String result = "First Number: " + num1 + "\n" +
                        "Second Number: " + num2 + "\n\n" +
                        "Sum: " + sum + "\n" +
                        "Difference: " + difference + "\n" +
                        "Product: " + product + "\n";

        if (num2 != 0) {
            double quotient = num1 / num2;
            result += "Quotient: " + quotient + "\n";
        } else {
            result += "Division by zero is not allowed.\n";
        }

        JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
