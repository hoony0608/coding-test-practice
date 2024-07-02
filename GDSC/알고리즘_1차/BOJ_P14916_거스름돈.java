package 알고리즘_1차;

import java.util.Scanner;

public class BOJ_P14916_거스름돈 {

    static int n;
    static int[] dp = new int[100004];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 2;
        dp[5] = 1;

        for(int i = 6; i <= n; i++) {
            if(dp[i - 2] == 0 && dp[i - 5] == 0) {
                dp[i] = 0;
            } else if(dp[i - 2] > 0 && dp[i - 5] == 0) {
                dp[i] = dp[i - 2] + 1;
            } else if(dp[i - 2] == 0 && dp[i - 5] > 0) {
                dp[i] = dp[i - 5] + 1;
            } else {
                dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
            }
        }

        if(dp[n] == 0) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
