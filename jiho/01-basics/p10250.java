import java.io.*;
import java.util.StringTokenizer;

public class p10250 {
    // p10250
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());

            String x = Integer.toString(((n - 1) / h) + 1);
            String y = Integer.toString(n % h);

            if(x.length() == 1) {
                x = "0" + x;
            }
            if(y.equals("0")) {
                y = Integer.toString(h);
            }
            System.out.println(y + x);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
