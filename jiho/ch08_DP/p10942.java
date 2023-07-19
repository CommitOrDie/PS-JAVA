package ch08_DP;

import java.io.*;

public class p10942 {
    /* ch08_DP.p10942
     * 팰린드롬 판별
     * 범위가 1칸인 경우
     * 범위가 2칸인 경우
     * 범위가 3칸 이상인 경우
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];   // [i,j]: s가 i, e가 j일 때 팰린드롬인지 판별

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        // 팰린드롬 판별
        // 범위가 1칸인 경우는 항상 팰린드롬
        for(int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        // 범위가 2칸인 경우는 두 수가 같은 경우 팰린드롬
        for(int i = 0; i < n-1; i++) {
            if(nums[i] == nums[i+1]) {
                isPalindrome[i][i+1] = true;
            }
        }
        // 범위가 3칸 이상인 경우는 해당 범위에 속하는 수들이 팰린드롬이고, 양 끝의 수 s, e가 같으면 팰린드롬
        // 범위를 3칸부터 확장시키며 팰린드롬 판별
        for(int range = 3; range <= n; range++) {
            for(int s = 0; s <= n-range; s++) {
                int e = s+range-1;  // 범위가 끝나는 끝의 수

                // 범위에 속하는 수들이 팰린드롬이고, 양 끝의 수가 같은 경우
                if(isPalindrome[s+1][e-1] && nums[s] == nums[e]) {
                    isPalindrome[s][e] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            if(isPalindrome[s-1][e-1]) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
