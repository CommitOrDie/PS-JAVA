package ch07_sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p5648 {
    // ch07_sort.p5648
    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Long> list = new ArrayList<>();
        int n = Integer.parseInt(sc.next());
        String cur = "";
        for(int i = 0; i < n; i++) {
            cur = sc.next();
            StringBuffer curNum = new StringBuffer(cur).reverse();
            list.add(Long.parseLong(curNum.toString()));
        }

        Collections.sort(list);
        int size = list.size();
        for(int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
