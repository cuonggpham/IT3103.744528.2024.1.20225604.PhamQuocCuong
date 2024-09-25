// package lab01;

import javax.swing.JOptionPane;

public class CalculatorDialog {
    public static void main(String[] args) {
        // Get user input for the first number
        String strNum1 = JOptionPane.showInputDialog("Enter the first number:");

        // Get user input for the second number
        String strNum2 = JOptionPane.showInputDialog("Enter the second number:");

        // Convert the input strings to double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Calculate sum, difference, and product
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        
        // Initialize a string to store the result
        StringBuilder result = new StringBuilder();

        // Add input values to the result
        result.append("First Number: ").append(num1).append("\n");
        result.append("Second Number: ").append(num2).append("\n\n");

        // Add calculation results to the result
        result.append("Sum: ").append(sum).append("\n");
        result.append("Difference: ").append(difference).append("\n");
        result.append("Product: ").append(product).append("\n");

        // Check for division by zero
        if (num2 != 0) {
            double quotient = num1 / num2;
            result.append("Quotient: ").append(quotient).append("\n");
        } else {
            result.append("Division by zero is not allowed.\n");
        }

        // Display the result in a dialog box
        JOptionPane.showMessageDialog(null, result.toString(), "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
    }
}

