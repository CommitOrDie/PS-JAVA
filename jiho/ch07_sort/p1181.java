package ch07_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class p1181 {
    // ch07_sort.p1181
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if(!list.contains(input)) {
                list.add(input);
            }
        }

        Collections.sort(list, new CompareString());

        int size = list.size();
        for(int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
    }

    static class CompareString implements Comparator {
        /*
         * 반환값에 따라 정렬
         * 양수: o1과 o2의 위치 바꿈
         * 0: o1과 o2의 위치 바꾸지 않음 (같음)
         * 음수: o1과 o2의 위치 바꿈
         */
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            // 문자열의 길이가 짧은 것을 우선으로 정렬
            if(s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() == s2.length()) {
                return s1.compareTo(s2);    // 길이가 같으면 사전순으로 정렬
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
