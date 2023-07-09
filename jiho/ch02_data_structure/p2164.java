package ch02_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p2164 {
    // ch02_data_structure.p2164
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() >= 2) {
            queue.remove(); // 제일 위에있는 카드 버리기
            int card = queue.remove();
            queue.add(card);
        }
        System.out.println(queue.remove());
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
