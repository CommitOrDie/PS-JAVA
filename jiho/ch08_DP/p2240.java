package ch08_DP;

import java.io.*;

public class p2240 {
    // ch08_DP.p2240
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int T = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        
        // dp[i][j]: 현재 시간이 i일 때, j번 이동한 경우 얻을 수 있는 자두의 최대 개수
        int[][] dp = new int[T+1][W+1];

        for(int i = 1; i <= T; i++) {
            int curTree = Integer.parseInt(br.readLine());

            // 한번도 움직이지 않은 경우, 현재 위치는 1번 나무 아래. 1번 나무의 자두가 떨어지는 경우 +1, 아닌 경우 +0
            if(curTree == 1)
                dp[i][0] = dp[i-1][0] + 1;
            else
                dp[i][0] = dp[i-1][0];

            for(int j = 1; j <= W; j++) {
                if(curTree == 1) {      // 1번 나무의 열매가 떨어지는 경우
                    if(j % 2 == 0) {    // j가 짝수인 경우, 현재 위치는 1번 나무 아래
                        // dp[i-1][j]: 이전 단계들에서 이미 j번 움직여 현재 단계에서는 움직이지 않은 경우
                        // dp[i-1][j-1]: 이전 단계들에서 j-1번 움직이고, 현재 단계에서 움직이는 경우
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + 1;
                    } else {            // j가 홀수인 경우, 현재 위치는 2번 나무 아래
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
                    }
                } else {                // 2번 나무의 열매가 떨어지는 경우
                    if(j % 2 == 0) {    // j가 짝수인 경우, 현재 위치는 1번 나무 아래
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
                    } else {            // j가 홀수인 경우, 현재 위치는 2번 나무 아래
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + 1;
                    }
                }
            }
        }

        // 정답 출력
        int ans = 0;
        for(int i = 0; i <= W; i++) {
            ans = Math.max(ans, dp[T][i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}