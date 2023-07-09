package ch02_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2346 {
    // ch02_data_structure.p2346
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int balloons[] = new int[n];
        boolean isVisited[] = new boolean[n];
        String ans = "1 ";

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
             balloons[i] = Integer.parseInt(stk.nextToken());
        }

        int cnt = 1;                         // 터뜨린 풍선의 개수
        int curIdx = 0;
        int curPaper = balloons[curIdx];     // 마지막으로 터뜨린 풍선의 종이에 적혀있는 값
        isVisited[curIdx] = true;
        while(cnt < n) {
            int idx = curIdx;
            int moveCnt = 0;                 // 현재 이동한 횟수
            int direction = curPaper / Math.abs(curPaper);
            while(moveCnt < Math.abs(curPaper)) {
                idx += direction;
                if(idx == -1) {
                    idx = n-1;
                }
                if(idx == n) {
                    idx = 0;
                }

                if(!isVisited[idx]) {
                    moveCnt++;
                }
            }
            cnt++;
            curIdx = idx;
            curPaper = balloons[curIdx];
            isVisited[curIdx] = true;

            ans += (curIdx + 1) + " ";
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
