package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1788 {
    // ch08_DP.p1788
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX = 1_000_000;
        final int MOD = 1_000_000_000;

        int n = Integer.parseInt(br.readLine());
        int[] fibo = new int[MAX + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i <= Math.abs(n); i++) {
            fibo[i] = (fibo[i-1] % MOD + fibo[i-2] % MOD) % MOD;
        }

        int ans = fibo[Math.abs(n)];

        // 음수 n에 대한 피보나치 값은 음수, 양수로 진동하는 형태
        if(n < 0 && n % 2 == 0) System.out.println(-1);
        else if(n == 0) System.out.println(0);
        else System.out.println(1);

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
