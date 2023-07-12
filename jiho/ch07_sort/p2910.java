package ch07_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2910 {
    // ch07_sort.p2910
    static Map<Integer, Integer> map = new HashMap<>();    // <값, 등장 횟수>

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int size = input.length;
        for(int i = 0; i < size; i++) {
            int cur = Integer.parseInt(input[i]);
            if(!list.contains(cur)) {
                list.add(cur);
            }
            // map의 put은 해당 key를 갖는 원소가 있는 경우 갱신, 없는 경우 추가함
            // 현재 값을 key로 갖는 value가 있는 경우: 해당 value에 1을 더해 반영
            // 현재 값을 key로 갖는 value가 있는 경우: 1을 value로 저장
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        Collections.sort(list, new IntegerComparator());

        StringBuilder sb = new StringBuilder();
        size = list.size();
        for(int i = 0; i < size; i++) {
            int cur = list.get(i);
            for(int j = 0; j < map.get(cur); j++) {
                sb.append(cur + " ");
            }
        }
        System.out.println(sb.toString());
    }

    static class IntegerComparator implements Comparator<Integer> {
        // 빈도수가 큰 순으로 정렬
        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2) - map.get(o1);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
