package ch08_DP;

import java.io.*;
import java.util.StringTokenizer;

public class p9084 {
    // ch08_DP.p9084
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int T = Integer.parseInt(br.readLine());
        for(int TC = 1; TC <= T; TC++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[10001];

            dp[0] = 1;
            stk = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                int curCoin = Integer.parseInt(stk.nextToken());
                for(int j = curCoin; j <= 10000; j++) {
                    dp[j] = dp[j] + dp[j - curCoin];
                }
            }
            int target = Integer.parseInt(br.readLine());
            bw.write(dp[target] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
