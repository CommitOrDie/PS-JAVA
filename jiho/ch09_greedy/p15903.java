package ch09_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15903 {
    /* ch09_greedy.p15903
     * 매 합체마다 가장 작은 두 수를 선택하면 최소 점수를 얻을 수 있음
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        long[] cards = new long[n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(stk.nextToken());
        }

        for(int i = 0; i < m; i++) {
            // 매 합체마다 가장 작은 두 수 선택
            Arrays.sort(cards);
            long x = cards[0];
            long y = cards[1];
            cards[0] = x + y;
            cards[1] = x + y;
        }

        long ans = Arrays.stream(cards).sum();

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
