package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2293 {
    // ch08_DP.p2293
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] dp = new int[k+1];    // dp[i]: i를 만들 수 있는 경우의 수

        // 처음으로 동전을 만나게 되었을 때, 해당 동전으로만 수를 만드는 경우의 수는 1
        // 처음으로 동전을 만나는 경우: dp[j-curCoin] == dp[0]
        dp[0] = 1;
        // i번째 동전까지 사용했을 때 경우의 수를 갱신해나감
        for(int i = 0; i < n; i++) {
            int curCoin = Integer.parseInt(br.readLine());

            // 현재 동전보다 작은 값은 현재 동전으로 표현할 수 없으므로, 현재 동전의 값보다 크거나 같은 값부터 갱신
            for(int j = curCoin; j <= k; j++) {
                // 이전까지 j를 만드는 경우의 수 + j-curCoin을 만드는 경우의 수(curCoin 하나만 추가하면 되는 경우)
                dp[j] = dp[j] + dp[j - curCoin];
            }
        }

        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
