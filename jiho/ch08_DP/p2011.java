package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2011 {
    // ch08_DP.p2011
    private static final int MOD = 1000000;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        int len = str.length;
        int[] dp = new int[len + 1];

        dp[0] = 1;
        for(int i = 1; i <= len; i++) {
            int cur = str[i-1] - '0';

            if(1 <= cur && cur <= 9)
                dp[i] = (dp[i] % MOD + dp[i-1] % MOD) % MOD;    // 이전 경우의 수에 현재 수를 추가만 하는 경우
            
            if(i == 1) continue;    // 첫번째 수인 경우, prev가 존재하지 않으므로 continue
            
            int prev = str[i-2] - '0';
            int curNum = 10 * prev + cur;
            
            if(prev == 0)
                continue; // prev가 0으로 시작할 수 없음. prev와 cur가 모두 0인 경우, dp[i]는 0이 되고, dp[i]가 한번 0이 되면 다음 dp[k]값들도 모두 0이 됨

            if(10 <= curNum && curNum <= 26)
                dp[i] = (dp[i] % MOD + dp[i-2] % MOD) % MOD;    // 이전 경우의 수의 마지막 수와 현재 수를 붙이는 경우
        }
        System.out.println(dp[len]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
