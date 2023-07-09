package ch02_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1158 {
    // ch02_data_structure.p1158
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        StringBuilder ans = new StringBuilder("<");
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int cur = k-1;
        while(1 < list.size()) {
            ans.append(list.remove(cur) + ", ");
            cur = (cur + k - 1) % list.size();
        }
        ans.append(list.remove() + ">");
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
