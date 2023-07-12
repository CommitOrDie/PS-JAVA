package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11659 {
    // ch08_DP.p11659
    // 이전까지 값들의 합을 미리 계산해두고, dp[j] - dp[i]와 같이 구간합 계산
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] dp = new int[n+1];    // dp[i]: i번째 수 까지의 합

        input = br.readLine().split(" ");
        dp[1] = Integer.parseInt(input[0]);
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(input[i - 1]);
        }

        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int st = Integer.parseInt(input[0]);
            int en = Integer.parseInt(input[1]);

            System.out.println(dp[en] - dp[st-1]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
