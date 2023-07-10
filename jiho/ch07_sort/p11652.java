package ch07_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p11652 {
    // ch07_sort.p11652
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Long, Long> cardCnt = new HashMap<>();   // {카드의 값, 카드 등장 횟수}
        long maxVal = 0;    // 가장 많이 등장한 카드의 값
        long maxCnt = 0;    // 가장 많이 등장한 카드의 등장 횟수
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            long cur = Long.parseLong(br.readLine());
            long curCnt;
            if(cardCnt.containsKey(cur)) {
                // 이미 현재 카드가 등장한 경우
                curCnt = cardCnt.get(cur) + 1;
            } else {
                // 현재 카드가 처음 등장한 경우
                curCnt = 1L;
            }
            cardCnt.put(cur, curCnt);

            // 최대 카드 등장 횟수 갱신
            if(maxCnt < curCnt) {
                maxVal = cur;
                maxCnt = curCnt;
            } else if(maxCnt == curCnt) {
                // 등장 횟수가 같은 경우, 더 작은 값을 출력하기 위함
                if(cur < maxVal) {
                    maxVal = cur;
                    maxCnt = curCnt;
                }
            }
        }
        System.out.println(maxVal);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
