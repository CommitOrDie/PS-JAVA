package ch05_backtracking;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class p15649 {
    // ch05_backtracking.p15649
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer stk;
    static int n, m;
    static int[] numbers;
    static Vector<Integer> selected = new Vector<>();

    public static void combination(int cur) throws IOException{
        // m개의 수를 선택한 경우
        if(selected.size() == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(selected.get(i) + " ");
            }
            bw.write(sb.toString() + "\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!selected.contains(i)) {
                selected.add(i);
                combination(i+1);
                selected.remove(selected.size()-1);
            }
        }
    }

    public static void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        numbers = new int[n];

        for(int i = 0; i < n; i++) {
            numbers[i] = i+1;
        }

        combination(1);

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
