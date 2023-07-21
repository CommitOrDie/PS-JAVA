package ch09_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1439 {
    // ch09_greedy.p1439
    // 연속된 1로 구성된 토큰의 개수와 연속된 0으로 구성된 토큰의 개수 중 작은 것을 출력
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int[] area = new int[2];    // area[i]: 연속된 i로 이루어진 문자 집합의 개수
        char prev = str[0];
        area[prev - '0']++;
        for(int i = 1; i < str.length; i++) {
            char cur = str[i];
            if(prev != cur) {
                area[cur - '0']++;
            }
            prev = cur;
        }

        int ans = Math.min(area[0], area[1]);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
