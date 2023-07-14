package ch08_DP;

import java.io.*;

public class p15988 {
    /* ch08_DP.p15988
     * i를 만드는 방법
     * (i-1) + 1
     * (i-2) + 2
     * (i-3) + 3
     * 즉, dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MAX = 1000000;
        int DIV = 1000000009;
        long[] dp = new long[MAX + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= MAX; i++) {
            dp[i] = (dp[i - 1] % DIV + dp[i - 2] % DIV + dp[i - 3] % DIV) % DIV;
        }

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}