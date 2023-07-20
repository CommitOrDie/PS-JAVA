package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2133 {
    // ch08_DP.p2133
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];     // dp[i]: 3xi 벽을 타일로 채운 경우의 수
        int[] tiles = new int[n+1];  // tiles[i]: 너비가 i인 타일 중 너비가 i 미만인 타일들로는 구성되지 않는 경우의 수

        // 너비가 2가 되는 경우의 수는 3가지, 그보다 큰 경우는 2가지
        tiles[2] = 3;
        for(int i = 4; i <= n; i += 2) {
            tiles[i] = 2;
        }

        dp[2] = tiles[2];
        for(int i = 4; i <= n; i += 2) {
            // dp[i-j] * blocks[j]: 너비가 i-j인 경우에서, 너비가 j인 타일을 붙이는 경우
            for(int j = 2; j < i; j += 2) {
                dp[i] += dp[i-j] * tiles[j];
            }
            // 너비가 i인 타일의 조합의 경우의 수도 더해줌
            dp[i] += tiles[i];
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
