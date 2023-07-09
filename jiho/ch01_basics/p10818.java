package ch01_basics;

import java.io.*;
import java.util.*;

public class p10818 {
    public static void solution() throws IOException {
        // ch1_basics.p10818
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int max = -1000001;
        int min = 1000001;

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(stk.nextToken());
            if(max < cur) {
                max = cur;
            }
            if(cur < min) {
                min = cur;
            }
        }

        System.out.println(min + " " + max);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
