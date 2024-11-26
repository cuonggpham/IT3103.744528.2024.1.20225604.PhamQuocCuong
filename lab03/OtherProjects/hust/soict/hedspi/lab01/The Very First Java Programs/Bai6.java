import java.util.Scanner;

public class Bai6 {
    // Select the type of equation to solve:
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Pham Quoc Cuong - 5604 - Select the type of equation to solve:");
        System.out.println("1. First-degree equation");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                giaiPTBac1(sc);
                break;
            case 2:
                giaiHPTBac1(sc);
                break;
            case 3:
                giaiPTBac2(sc);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void giaiPTBac1(Scanner sc) {
        System.out.println("Solving first-degree equation: ");
        System.out.print("Enter a (a != 0): ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        if (a == 0) {
            System.out.println("Invalid input. a != 0.");
        } else {
            double x = -b / a;
            System.out.println("Solution: x = " + x);
        }
    }

    public static void giaiHPTBac1(Scanner sc) {
        System.out.println("Solving system of two first-degree equations:");
        System.out.print("Enter a11: ");
        double a11 = sc.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = sc.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = sc.nextDouble();
        System.out.print("Enter a21: ");
        double a21 = sc.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = sc.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = sc.nextDouble();

        // Calculate determinants
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
        }
    }

    public static void giaiPTBac2(Scanner sc) {
        System.out.println("Solving second-degree equation: ");
        System.out.print("Enter a (a != 0): ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        if (a == 0) {
            System.out.println("Invalid input. a != 0.");
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The equation has two distinct real roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has a double root: x = " + x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }
}
