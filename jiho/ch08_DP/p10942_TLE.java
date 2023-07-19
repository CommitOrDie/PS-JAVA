package ch08_DP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p10942_TLE {
    // ch08_DP.p10942-TLE (O(N^3))
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        // 팰린드롬 찾기(O(n^3))
        List[] palindrome = new List[n];
        for(int i = 0 ; i < n; i++) {
            palindrome[i] = new ArrayList<>();
            for(int j = i; j < n; j++) {
                if(nums[i] != nums[j]) continue;

                boolean isPalindrome = true;
                for(int k = 0; k <= (j-i)/2; k++) {
                    if(nums[i+k] != nums[j-k]) {
                        isPalindrome = false;
                        break;
                    }
                }
                if(isPalindrome) palindrome[i].add(j);
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            if(palindrome[s-1].contains(e-1)) {
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
