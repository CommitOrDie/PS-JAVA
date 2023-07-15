package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1904 {
    // ch08_DP.p1904
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int MOD = 15746;

        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < N; i++) {
            dp[i] = (dp[i-1] % MOD + dp[i-2] % MOD) % MOD;
        }

        System.out.println(dp[N-1]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
