import java.util.Scanner;

class Factorial {

    int fact(int n) {

        if (n == 0 || n == 1)
            return 1;

        return n * fact(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        Factorial obj = new Factorial();

        System.out.println("Factorial = " + obj.fact(n));
    }
}