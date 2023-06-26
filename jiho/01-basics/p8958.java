import java.io.*;
import java.util.StringTokenizer;

public class p8958 {
    // p8958
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < t; i++) {
            stk = new StringTokenizer(br.readLine());
            char input[] = stk.nextToken().toCharArray();
            int score = 0;  // 현재 테스트 케이스의 점수
            int streak = 0; // 현재 연속으로 나온 O의 개수

            for(int j = 0; j < input.length; j++) {
                if(input[j] == 'O') {
                    // 현재 보고있는 문자가 'O'인 경우
                    streak++;
                    score += streak;
                } else {
                    // 현재 보고있는 문자가 'X'인 경우
                    streak = 0;
                }
            }
            bw.write(score + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
