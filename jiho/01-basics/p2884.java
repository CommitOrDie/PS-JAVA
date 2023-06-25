import java.io.*;
import java.util.*;

public class p2884 {
    // p2884
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        if(m < 45) {
            h = (h + 24 - 1) % 24;
        }
        m = (m + 60 - 45) % 60;

        bw.write(h + " " + m);
        bw.flush();
        bw.close();
    }

    public static void main(String args[]) throws IOException {
        solution();
    }
}
