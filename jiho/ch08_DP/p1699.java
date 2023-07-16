package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1699 {
    // ch08_DP.p1699
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            dp[i] = i;  // 1로만 표현하는 경우
            for(int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
