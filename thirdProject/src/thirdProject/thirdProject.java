package thirdProject;

import java.util.Scanner;

public class thirdProject {
    static final int MOD = 1000000007;

	public static void main(String[] args) {
				System.out.println("Enter array matris:");
		        Scanner scanner = new Scanner(System.in);
		        int n = scanner.nextInt();
		        int m = scanner.nextInt();
		        int[][] grid = new int[n][m];

		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < m; j++) {
		                grid[i][j] = scanner.nextInt();
		            }
		        }
		        scanner.close();

		        int[][] dp = new int[n][m];
		        dp[0][0] = 1;

		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < m; j++) {
		                if (isPrime(grid[i][j])) {
		                    if (i > 0) {
		                        dp[i][j] += dp[i - 1][j];
		                        dp[i][j] %= MOD;
		                    }
		                    if (j > 0) {
		                        dp[i][j] += dp[i][j - 1];
		                        dp[i][j] %= MOD;
		                    }
		                    if (i > 0 && j > 0) {
		                        dp[i][j] += dp[i - 1][j - 1];
		                        dp[i][j] %= MOD;
		                    }
		                }
		            }
		        }
		        	
		        System.out.println(dp[n - 1][m - 1]);

		        if (dp[n - 1][m - 1] != 0) {
		            int i = n - 1;
		            int j = m - 1;
		            while (i != 0 || j != 0) {
		                System.out.println((i + 1) + " " + (j + 1));
		                if (i > 0 && j > 0 && dp[i - 1][j - 1] > 0) {
		                    i--;
		                    j--;
		                } else if (i > 0 && dp[i - 1][j] > 0) {
		                    i--;
		                } else {
		                    j--;
		                }
		            }
		            System.out.println("1 1");
		        }
		    }

		    private static boolean isPrime(int n) {
		        if (n <= 1) {
		            return false;
		        }
		        for (int i = 2; i * i <= n; i++) {
		            if (n % i == 0) {
		                return false;
		            }
		        }
		        return true;
		    }
}
