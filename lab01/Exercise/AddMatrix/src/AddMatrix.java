package Exercise.AddMatrix.src;

import java.util.Scanner;

public class AddMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pham Quoc Cuong - 5604 - Do you want to enter your own matrices? (yes/no): ");
        String userChoice = scanner.nextLine().trim().toLowerCase();

        int rows, cols;
        double[][] matrix1, matrix2, resultMatrix;

        if (userChoice.equals("yes")) {
            System.out.print("Enter the number of rows for the matrices: ");
            rows = scanner.nextInt();
            System.out.print("Enter the number of columns for the matrices: ");
            cols = scanner.nextInt();

            matrix1 = new double[rows][cols];
            matrix2 = new double[rows][cols];
            resultMatrix = new double[rows][cols];

            System.out.println("Enter elements for the first matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrix1[i][j] = scanner.nextDouble();
                }
            }

            System.out.println("Enter elements for the second matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrix2[i][j] = scanner.nextDouble();
                }
            }

        } else {
            matrix1 = new double[][]{
                {1.5, 2.3, 3.7},
                {4.1, 5.8, 6.0},
                {7.9, 8.2, 9.5}
            };

            matrix2 = new double[][]{
                {9.1, 8.4, 7.2},
                {6.3, 5.7, 4.4},
                {3.6, 2.5, 1.8}
            };

            rows = matrix1.length;
            cols = matrix1[0].length;
            resultMatrix = new double[rows][cols];

            System.out.println("Using predefined matrices.");
        }
        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Resulting matrix after addition:");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f ", value); 
            }
            System.out.println();
        }
    }
}
