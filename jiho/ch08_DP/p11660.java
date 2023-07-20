package ch08_DP;

import java.io.*;
import java.util.StringTokenizer;

public class p11660 {
    // ch08_DP.p11660
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];     // dp[i][j] : (1, 1) ~ (i, j) 까지의 누적합

        for(int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
                // 위쪽 + 왼쪽 - 겹치는 부분 + 현재 칸
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }

        for(int TC = 1; TC <= m; TC++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            // 현재 칸 까지의 누적합 - 위쪽 - 왼쪽 + 겹치는 부분
            int ans = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
