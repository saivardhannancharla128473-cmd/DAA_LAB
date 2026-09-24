import java.util.*;

public class coinChange {

    static int coinChange(int N, int[] coins) {
        int m = coins.length;
        int[][] dp = new int[m + 1][N + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= N; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[m][N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount N: ");
        int N = sc.nextInt();

        System.out.print("Enter number of coins: ");
        int m = sc.nextInt();

        int[] coins = new int[m];

        System.out.println("Enter coin values:");

        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println("Number of ways = " + coinChange(N, coins));

        sc.close();
    }
}