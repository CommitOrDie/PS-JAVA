package ch07_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p10825 {
    // ch07_sort.p10825
    static class Score implements Comparable {
        String name;
        int kor;
        int eng;
        int math;

        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Object o) {
            Score s = (Score) o;

            if (kor != s.kor) {
                return s.kor - kor;
            } else {
                if (eng != s.eng) {
                    return eng - s.eng;
                } else {
                    if (math != s.math) {
                        return s.math - math;
                    } else {
                        return name.compareTo(s.name);
                    }
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Score> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] cur = br.readLine().split(" ");
            String name = cur[0];
            int kor = Integer.parseInt(cur[1]);
            int eng = Integer.parseInt(cur[2]);
            int math = Integer.parseInt(cur[3]);
            list.add(new Score(name, kor, eng, math));
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
