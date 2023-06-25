import java.io.*;
import java.util.StringTokenizer;

public class p2920 {
    // p2920
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        boolean isAsc;
        int prev = Integer.parseInt(stk.nextToken());
        int cur = Integer.parseInt(stk.nextToken());

        if(prev < cur) {
            isAsc = true;
        } else {
            isAsc = false;
        }

        int repeat = stk.countTokens();
        for(int i = 0; i < repeat; i++) {
            prev = cur;
            cur = Integer.parseInt(stk.nextToken());

            if((isAsc && prev > cur) || (!isAsc && prev < cur)) {
                bw.write("mixed");
                bw.flush();
                bw.close();
                return;
            }
        }

        if(isAsc) {
            bw.write("ascending");
        } else {
            bw.write("descending");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
