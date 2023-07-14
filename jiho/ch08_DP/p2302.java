package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2302 {
    // ch08_DP.p2302
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];

        dp[0] = 1;  // dummy
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++) {
            // VIP석이 없는 경우를 가정한 경우의 수 계산
            // dp[i]: i번째 좌석까지의 경우의 수
            // dp[i-1]: i-1번째 좌석을 배치하는 경우에 i번째 좌석만 추가하는 경우
            // dp[i-2]: i-2번째 좌석을 배치하고, i번째 좌석과 i-1번째 좌석의 위치를 바꿔서 추가하는 경우
            dp[i] = dp[i-1] + dp[i-2];
        }

        // 각 vip석 사이의 좌석들의 경우의수를 곱해줌
        int ans = 1;
        int prev = 0;
        int cur = 0;
        for(int i = 0; i < M; i++) {
            cur = Integer.parseInt(br.readLine());
            ans *= dp[cur - prev - 1];
            prev = cur;
        }
        // 마지막 vip ~ 마지막 자리 까지의 경우의 수 계산
        // 마지막 vip 좌석 번호가 마지막 자리의 번호와 같은 경우, 미리 넣어둔 더미데이터 d[0] == 1 이 곱해짐
        ans *= dp[N - prev];   

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
