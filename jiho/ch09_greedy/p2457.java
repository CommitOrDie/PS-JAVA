package ch09_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2457 {
    // ch09_greedy.p2457
    private static class Flower implements Comparable<Flower> {
        int start;  // 꽃이 피는 날짜
        int end;    // 꽃이 지는 날짜

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 꽃이 피는 날짜가 빠르고, 꽃이 지는 날짜가 느린 것이 우선순위가 높음
        // 꽃이 지는 날짜가 빠른 꽃을 큐에서 제거하며 선택할 꽃을 찾으므로 빨리 지는 순으로 정렬
        @Override
        public int compareTo(Flower flower) {
            if(this.start == flower.start) {
                return flower.end - this.end;
            } else {
                return this.start - flower.start;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(stk.nextToken());
            int startDate = Integer.parseInt(stk.nextToken());
            int endMonth = Integer.parseInt(stk.nextToken());
            int endDate = Integer.parseInt(stk.nextToken());

            // 날짜를 정수로 표현. e.g) 10월 3일: 1003, 7월 21일: 721
            int s = startMonth * 100 + startDate;
            int e = endMonth * 100 + endDate;

            flowers[i] = new Flower(s, e);
        }

        Arrays.sort(flowers);

        int ans = 0;
        int idx = 0;
        int prev = 301;         // 이전 꽃이 지는 날짜
        int end = 1201;         // 꽃이 피어있어야 할 마지막 날짜
        while(prev < end) {     // 이전 꽃이 마지막 날짜보다 이전에 지는 경우 새로운 꽃을 추가해야함
            int maxEnd = prev;
            boolean isSelected = false; // 추가할 꽃을 발견했는지 여부

            for(int i = idx; i < n; i++) {
                // flowers는 시작 날짜가 빠른 순으로 정렬되어있음
                // 이전 종료 날짜보다 현재 시작 날짜가 느리다면 공백이 있음을 의미함
                if(prev < flowers[i].start) {
                    break;
                }

                // 공백이 없으면서 가장 늦게 지는 꽃 선택
                if(maxEnd < flowers[i].end) {
                    maxEnd = flowers[i].end;
                    isSelected = true;
                    idx = i + 1;    // 현재 i번째 꽃을 선택했다고 가정하고, 다음 꽃을 선택할 때는 i + 1번째 꽃부터 살펴봄
                }
            }
            
            if(isSelected) {
                prev = maxEnd;
                ans++;
            } else {    // 아무 꽃도 선택되지 않은 경우, 공백이 있는 경우임
                break;
            }
        }

        // 3월 1일 ~ 11월 30 까지 모두 채우지 못한 경우
        if(prev < end) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String args[]) throws IOException {
        solution();
    }
}
