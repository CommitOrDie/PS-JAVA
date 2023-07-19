package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2294 {
    // ch08_DP.p2294
    static final int INF = 10001;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] coins = new int[n];
        int[] dp = new int[100001];  // dp[i]: i원을 만드는데 필요한 동전의 최소 개수

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i <= k; i++) {
            dp[i] = INF;
        }

        for(int i = 0; i < n; i++) {
            int curCoin = coins[i];

            dp[curCoin] = 1;
            for(int j = 2; j*curCoin <= k; j++) {
                dp[j*curCoin] = Math.min(dp[j*curCoin], dp[(j-1)*curCoin] + 1);
            }
            for(int j = 1; j <= k; j++) {
                if(dp[j] != INF && j+curCoin <= k) {
                    dp[j+curCoin] = Math.min(dp[j+curCoin], dp[j] + 1);
                }
            }
        }

        if(dp[k] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
