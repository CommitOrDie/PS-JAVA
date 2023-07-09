package ch01_basics;

import java.io.*;
import java.util.StringTokenizer;

public class p10809 {
    // ch1_basics.p10809
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        char input[] = stk.nextToken().toCharArray();
        int ans[] = new int[26];

        // 초기화
        for(int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        for(int i = 0; i < input.length; i++) {
            if(ans[input[i] - 'a'] == -1) {
                ans[input[i] - 'a'] = i;
            }
        }

        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
