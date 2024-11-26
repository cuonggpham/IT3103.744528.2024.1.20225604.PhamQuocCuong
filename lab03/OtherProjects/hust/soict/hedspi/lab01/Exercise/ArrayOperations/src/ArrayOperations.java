package Exercise.ArrayOperations.src;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pham Quoc Cuong - 5604 - Do you want to enter your own array? (yes/no): ");
        String userChoice = scanner.nextLine().trim().toLowerCase();

        double[] numbers;

        if (userChoice.equals("yes")) {
            System.out.print("Enter the number of elements in the array: ");
            int n = scanner.nextInt();

            numbers = new double[n];

            System.out.println("Enter " + n + " elements of the array:");
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextDouble();
            }
        } else {
            numbers = new double[]{10.5, 5.2, 8.3, 3.1, 2.8};  
            System.out.println("Using the constant array: " + Arrays.toString(numbers));
        }

        Arrays.sort(numbers);

        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / numbers.length;

        System.out.println("Sorted array: " + Arrays.toString(numbers));
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);

        scanner.close();
    }
}
