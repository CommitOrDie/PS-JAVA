package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1915 {
    // ch08_DP.p1915
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] dp = new int[n+1][m+1];

        int maxLen = 0;
        for(int i = 1; i <= n; i++) {
            char[] row = br.readLine().toCharArray();
            dp[i][1] = row[0] - '0';
            maxLen = Math.max(maxLen, dp[i][1]);
            for(int j = 2; j <= m; j++) {
                if(row[j-1] != '1') continue;
                /*
                 * 현재 칸의 수가 1인 경우, 왼쪽, 왼쪽 위, 위쪽 칸의 값 중 가장 작은 값에 1을 더해 저장
                 * 세 방향 중 0이 존재한다면 가능한 최대 정사각형의 변의 길이는 1
                 */
                dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        System.out.println(maxLen * maxLen);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
