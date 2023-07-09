package ch01_basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11720 {
    // ch1_basics.p11720
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        char str[] = stk.nextToken().toCharArray();
        int sum = 0;

        for(int i = 0; i < str.length; i++) {
            sum += str[i] - '0';
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
