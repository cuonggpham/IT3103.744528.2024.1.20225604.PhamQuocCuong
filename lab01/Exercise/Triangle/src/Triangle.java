import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the height of the triangle: ");
        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            // In khoang trang 
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            // In dau * 
            for(int k=1; k <= 2*i-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
