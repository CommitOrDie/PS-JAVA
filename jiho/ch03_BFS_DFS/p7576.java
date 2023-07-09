package ch03_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {
    // ch03_BFS_DFS.p7576
    static class Location {
        int row;
        int col;
        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stk.nextToken());  // 상자의 가로 칸의 수
        int n = Integer.parseInt(stk.nextToken());  // 상자의 세로 칸의 수
        int[][] tomatoes = new int[n][m];
        int[][] time = new int[n][m];               // 해당 위치의 토마토가 익는데 걸린 시간
        int[] dirR = {1, 0, -1, 0};
        int[] dirC = {0, 1, 0, -1};
        Queue<Location> queue = new LinkedList<>();
        int ans = 0;

        // 입력
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(stk.nextToken());
                time[i][j] = -1;    // (i, j) 칸의 토마토를 방문하지 않았음을 뜻함
                if(tomatoes[i][j] == 1) {
                    queue.add(new Location(i, j));
                    time[i][j] = 0;
                }
            }
        }
        
        // BFS
        while(!queue.isEmpty()) {
            Location cur = queue.remove();
            int curRow = cur.row;
            int curCol = cur.col;
            for(int i = 0; i < 4; i++) {
                int nextRow = curRow + dirR[i];
                int nextCol = curCol + dirC[i];
                if(0 <= nextRow && nextRow < n && 0 <= nextCol && nextCol < m
                        && tomatoes[nextRow][nextCol] != -1
                        && (time[nextRow][nextCol] == -1 || time[curRow][curCol] + 1 < time[nextRow][nextCol])) {
                    queue.add(new Location(nextRow, nextCol));
                    time[nextRow][nextCol] = time[curRow][curCol] + 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // error 검사. BFS 종료 후에도 익지 않은 토마토가 있는 경우
                if(tomatoes[i][j] == 0 && time[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                // time 배열의 최대값: 모든 토마토가 익는데 걸린 시간
                if(ans < time[i][j]) {
                    ans = time[i][j];
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
