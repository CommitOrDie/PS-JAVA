package ch09_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1026 {
    /* ch09_greedy.p1026
     * A를 오름차순으로 정렬
     * B를 오름차순으로 정렬
     * 반복문에서 ans += A[i]*B[n-i-1] 를 계산 (A는 첫 원소부터, B는 마지막 원소부터)
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int ans = 0;
        int n = Integer.parseInt(stk.nextToken());
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for(int i = 0; i < n; i++) {
            ans += arrA[i] * arrB[n-i-1];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
