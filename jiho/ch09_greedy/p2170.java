package ch09_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2170 {
    // ch09_greedy.p2170
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] lines = new int[n][2];  // line[i][0]: i번째 선의 x좌표, line[i][1]: i번째 선의 y좌표

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            lines[i][0] = x;
            lines[i][1] = y;
        }
        
        // x좌표를 기준으로 오름차순 정렬, x좌표가 같다면 y좌표를 기준으로 오름차순 정렬
        Arrays.sort(lines, (line1, line2) -> {
            if(line1[0] == line2[0]) {
                return line2[1] - line1[1];
            } else {
                return line1[0] - line2[0];
            }
        });

        // 이전 선분과 현재 선분을 비교해가며 답을 계산. 오름차순 정렬한 상태이므로 가능
        int prevX = lines[0][0];
        int prevY = lines[0][1];
        int ans = prevY - prevX;
        for(int i = 1; i < n; i++) {
            int curX = lines[i][0];
            int curY = lines[i][1];

            if(prevX <= curX && curY <= prevY) {    // 이전 선분과 현재 선분이 완전히 겹치는 경우
                continue;
            } else if (prevX < curX && curX < prevY && prevY < curY) {  // 현재 선분의 왼쪽 일부가 이전 선분과 겹치는 경우
                ans += curY - prevY;
            } else {    // 이전 선분과 현재 선분이 겹치지 않는 경우
                ans += curY - curX;
            }

            prevX = curX;
            prevY = curY;
        }
        System.out.println(ans);
    }

    public static void main(String args[]) throws IOException {
        solution();
    }
}
