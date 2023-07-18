package ch08_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9655 {
    // ch08_DP.p9655
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
