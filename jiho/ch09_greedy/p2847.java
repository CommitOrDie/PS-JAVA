package ch09_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2847 {
    // ch09_greedy.p2847
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int prev = arr[n - 1];
        for (int i = n-2; i >= 0; i--) {
            if (prev <= arr[i]) {
                ans += arr[i] - prev + 1;
                arr[i] = prev - 1;
            }
            prev = arr[i];
        }
        System.out.println(ans);
    }

    public static void main(String args[]) throws IOException {
        solution();
    }
}
