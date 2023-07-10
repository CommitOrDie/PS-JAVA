package ch07_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p11651 {
    // ch07_sort.p11651
    static class Loc implements Comparable<Loc> {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Loc loc) {
            if(loc.y < y) {
                return 1;
            } else if (loc.y > y) {
                return -1;
            } else {
                if(loc.x < x) {
                    return 1;
                } else if (loc.x > x){
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Loc> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            list.add(new Loc(x, y));
        }

        // sort & print
        Collections.sort(list);
        for(int i = 0; i < n; i++) {
            Loc curLoc = list.get(i);
            int curX = curLoc.x;
            int curY = curLoc.y;

            System.out.println(curX + " " + curY);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
