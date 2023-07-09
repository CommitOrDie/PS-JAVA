package ch01_basics;

import java.io.*;
import java.util.StringTokenizer;

public class p3052 {
    // ch1_basics.p3052
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        boolean isVisited[] = new boolean[42];
        int cnt = 0;

        for(int i = 0; i < 10; i++) {
            stk = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(stk.nextToken());
            int res = input % 42;
            if(!isVisited[res]) {
                // 이전에 나머지로 res가 나타나지 않은 경우
                isVisited[res] = true;
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    public static void main(String args[]) throws IOException {
        solution();
    }
}
