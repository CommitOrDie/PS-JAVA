package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p12852 {
    // ch08_DP.p12852
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int INF = 1000001;
        int[][] dp = new int[n + 1][2];  // dp[i][0]: n을 i로 만들기 위해 수행한 최소 연산 횟수
                                         // dp[i][1]: 현재 수 i를 만들기 위해 수행한 연산 직전의 값

        // dp 배열 초기화
        for(int i = 0; i <= n; i++) {
            dp[i] = new int[2];
            dp[i][0] = INF;
        }

        // BFS 사용
        Queue<Integer> q = new LinkedList<>();
        dp[n][0] = 0;
        q.add(n);
        while(!q.isEmpty()) {
            int cur = q.remove();
            int next;

            if(cur == 1) break;

            if(cur % 3 == 0) {
                next = cur / 3;
                if(dp[cur][0] + 1 < dp[next][0]) {
                    q.add(next);
                    dp[next][0] = dp[cur][0] + 1;
                    dp[next][1] = cur;
                }
            }
            if(cur % 2 == 0) {
                next = cur / 2;
                if(dp[cur][0] + 1 < dp[next][0]) {
                    q.add(next);
                    dp[next][0] = dp[cur][0] + 1;
                    dp[next][1] = cur;
                }
            }
            next = cur-1;
            if(dp[cur][0] + 1 < dp[next][0]) {
                q.add(next);
                dp[next][0] = dp[cur][0] + 1;
                dp[next][1] = cur;
            }
        }

        // 연산 과정을 역순으로 출력하기 위해 stack 사용
        Stack<Integer> s = new Stack<>();
        s.push(1);
        while(s.peek() != n) {
            int cur = s.peek();
            int prev = dp[cur][1];
            s.push(prev);
        }

        // 연산 과정 출력
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop() + " ");
        }

        System.out.println(dp[1][0]);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
