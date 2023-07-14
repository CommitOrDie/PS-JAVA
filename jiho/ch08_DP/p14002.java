package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14002 {
    // ch08_DP.p14002
    static class Sequence {
        int size;            // 수열의 크기
        String selected;     // 선택된 수열

        public Sequence(int size, String selected) {
            this.size = size;
            this.selected = selected;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Sequence[] dp = new Sequence[n];  // dp[i]: i번째 요소를 포함하는 가장 긴 증가하는 부분 수열 정보

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dp[0] = new Sequence(1, arr[0] + " ");
        for(int i = 1; i < n; i++) {
            // i번째 수를 포함할 수 있는 가장 긴 증가하는 부분 수열 찾기
            int maxIdx = -1;
            int maxSize = 0;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && maxSize < dp[j].size) {
                    maxIdx = j;
                    maxSize = dp[j].size;
                }
            }

            if(maxSize != 0) {
                // 현재 수를 포함할 수 있는 부분 수열이 존재하는 경우
                dp[i] = new Sequence(dp[maxIdx].size + 1, dp[maxIdx].selected + arr[i] + " ");
            } else {
                // 현재 수를 포함할 수 있는 부분 수열이 존재하지 않는 경우
                dp[i] = new Sequence(1, arr[i] + " ");
            }
        }

        int maxIdx = 0;
        int maxSize = 0;
        for(int i = 0; i < n; i++) {
            if(maxSize < dp[i].size) {
                maxIdx = i;
                maxSize = dp[i].size;
            }
        }
        System.out.println(maxSize);
        System.out.println(dp[maxIdx].selected);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
