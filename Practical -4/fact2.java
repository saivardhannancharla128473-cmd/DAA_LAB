import java.util.*;
public class fact2 {
    int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = s.nextInt();
        fact2 obj = new fact2();
        System.out.println("Factorial of "+n+": " + obj.factorial(n));
    }
}