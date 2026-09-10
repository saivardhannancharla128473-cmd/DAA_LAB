import java.util.*;

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        System.out.println("Enter dimensions:");
        int[] p = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int[][] m = new int[n][n];

        for (int length = 2; length <= n; length++) {

            for (int i = 0; i < n - length + 1; i++) {

                int j = i + length - 1;

                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = m[i][k]
                             + m[k + 1][j]
                             + p[i] * p[k + 1] * p[j + 1];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }

        System.out.println("Minimum number of multiplications: " + m[0][n - 1]);

        sc.close();
    }
}