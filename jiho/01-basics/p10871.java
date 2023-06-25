import java.io.*;
import java.util.*;

public class p10871 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            String token = stk.nextToken();
            if(Integer.parseInt(token) < x) {
                bw.write(token + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new p10871().solution();
    }
}
