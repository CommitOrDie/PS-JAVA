package ch09_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p1744 {
    // ch09_greedy.p1744
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            // 음수 또는 0인 경우와 양수인 경우를 나누어 저장
            if(cur <= 0) {
                negative.add(cur);
            } else {
                positive.add(cur);
            }
        }

        int ans = 0;
        Collections.sort(negative);
        for(int i = 0; i < negative.size(); i++) {
            // i가 마지막 원소를 가리키는 경우는 마지막 원소가 묶이지 않은 경우
            if(negative.size() == 1 || i == negative.size() - 1) {
                ans += negative.get(i);
            } else {
                ans += negative.get(i) * negative.get(i+1);
                i++;
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        for(int i = 0; i < positive.size(); i++) {
            // size가 1이거나,
            // 마지막 원소가 묶이지 않은 경우거나,
            // 두 원소가 모두 1인 경우는 묶지 않고 더해줌
            if(positive.size() == 1 || i == positive.size() - 1
                    || positive.get(i) >= positive.get(i) * positive.get(i+1)) {
                ans += positive.get(i);
            } else {
                ans += positive.get(i) * positive.get(i+1);
                i++;
            }
        }

        System.out.println(ans);
    }

    public static void main(String args[]) throws IOException {
        solution();
    }
}
