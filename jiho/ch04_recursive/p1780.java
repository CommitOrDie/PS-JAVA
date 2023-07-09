package ch04_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1780 {
    // ch04_recursive.p1780
    static int n;
    static int[][] paper;
    static long[] cnt = new long[3];

    public static void recursive(int startRow, int startCol, int curN) {
        int num = paper[startRow][startCol];
        int nextN = curN / 3;
        for(int i = 0; i < curN; i++) {
            for(int j = 0; j < curN; j++) {
                // 현재 종이의 모든 숫자가 같지 않은 경우
                if(paper[startRow + i][startCol + j] != num) {
                    for(int k = 0; k < 3; k++) {
                        for(int m = 0; m < 3; m++) {
                            recursive(startRow + k * nextN, startCol + m * nextN, nextN);
                        }
                    }
                    return;
                }
            }
        }
        cnt[num + 1]++;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        paper = new int[n][n];
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        recursive(0, 0, n);

        for(int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
