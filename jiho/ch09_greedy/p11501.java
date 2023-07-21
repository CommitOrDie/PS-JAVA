package ch09_greedy;

import java.io.*;
import java.util.StringTokenizer;

public class p11501 {
    /* ch09_greedy.p11501
     * 주식을 구입한 시점 이후로 주가가 가장 높은 날에 모두 판매
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int[] price = new int[n];

            for(int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(stk.nextToken());
            }

            long ans = 0;       // 최대 이익
            int curMax = 0;     // 현재 날짜 이후(현재 날짜 포함)의 최대 주가
            for(int i = n-1; i >= 0; i--) {
                curMax = Math.max(curMax, price[i]);

                // i일에 주식을 구입했을 경우, i일 이후에 판매했을 때 최대 이익을 얻을 수 있는 경우에만 구입 후 판매
                if(price[i] < curMax) {
                    ans += curMax - price[i];
                }
            }
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
