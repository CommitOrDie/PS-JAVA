import java.io.*;
import java.util.*;

public class p2675 {
     // p2675
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(stk.nextToken());
        for(int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(stk.nextToken());
            String s = stk.nextToken();

            for(int j = 0; j < s.length(); j++) {
                for(int k = 0; k < r; k++) {
                    bw.write(s.charAt(j));
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main (String[] args) throws IOException {
        solution();
    }
}
