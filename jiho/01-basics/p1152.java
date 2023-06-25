import java.io.*;
import java.util.*;

public class p1152 {
    // p1152
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        bw.write(stk.countTokens() + "");
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new p1152().solution();
    }
}
