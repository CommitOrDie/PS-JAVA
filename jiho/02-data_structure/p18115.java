import java.io.*;
import java.util.*;

public class p18115 {
    // p18115
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        Deque<Integer> idx = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int nextCard = n;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            idx.add(i);
        }

        stk = new StringTokenizer(br.readLine(), " ");
        while(stk.hasMoreTokens()) {
            int cur = Integer.parseInt(stk.nextToken());
            int first;
            int target;
            switch(cur) {
                case 1:
                    target = idx.removeFirst();
                    ans[target] = nextCard--;
                    break;
                case 2:
                    first = idx.removeFirst();
                    target = idx.removeFirst();
                    idx.addFirst(first);
                    ans[target] = nextCard--;
                    break;
                case 3:
                    target = idx.removeLast();
                    ans[target] = nextCard--;
                    break;
            }
        }
        for(int num : ans) {
            bw.write(num + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}
