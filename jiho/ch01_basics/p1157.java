package ch01_basics;

import java.io.*;

public class p1157 {
    // ch1_basics.p1157
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt[] = new int[26];
        int maxCnt = 0;
        int maxIdx = -1;

        String word = br.readLine().toLowerCase();
        char wordChar[] = word.toCharArray();

        for(int i = 0; i < word.length(); i++) {
            int curCnt = ++cnt[wordChar[i] - 'a'];
            if(maxCnt < curCnt) {
                maxCnt = curCnt;
                maxIdx = wordChar[i] - 'a';
            }
        }

        int dupleCnt = 0;
        for(int i = 0; i < 26; i++) {
            if(cnt[i] == maxCnt) {
                dupleCnt++;
            }
        }

        if(dupleCnt > 1) {
            bw.write("?");
        } else {
            bw.write((char)(maxIdx + 'A'));
        }

        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
