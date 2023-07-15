package ch08_DP;

import java.io.*;
import java.util.StringTokenizer;

public class p4883 {
    // ch08_DP.p4883
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        final int INF = 1001;
        int k = 0;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int[][] dp = new int[n][3];
            for(int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            // 첫번째 행 초기화
            dp[0][0] = INF;
            dp[0][2] += dp[0][1];

            for(int i = 1; i < n; i++) {
                for(int j = 0; j < 3; j++) {
                    if(j == 0) {    // 위, 오른쪽 위에서 들어오는 간선 존재
                        dp[i][j] += min(dp[i-1][j], dp[i-1][j+1]);
                    } else if (j == 1) {    // 왼쪽, 왼쪽 위, 위, 오른쪽 위에서 들어오는 간선 존재
                        dp[i][j] += min(dp[i][j-1], min(dp[i-1][j-1], min(dp[i-1][j], dp[i-1][j+1])));
                    } else {    // 왼쪽, 왼쪽 위, 위에서 들어오는 간선 존재
                        dp[i][j] += min(dp[i][j-1], min(dp[i-1][j-1], dp[i-1][j]));
                    }
                }
            }

            bw.write((++k) + ". " + dp[n-1][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
