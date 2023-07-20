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
        for(int i = 1; i <= k; i++) {
            dp[i] = INF;
        }

        for(int i = 0; i < n; i++) {
            // 현재 동전을 이용해 필요한 동전의 최소 개수를 갱신해나감
            int curCoin = coins[i];
            for(int j = curCoin; j <= k; j++) {
                // dp[0]이 0으로 초기화되어있어 dp[curCoin]은 1이 됨 
                dp[j] = Math.min(dp[j], dp[j-curCoin] + 1);
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
