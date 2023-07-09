package ch02_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p2493 {
    // ch02_data_structure.p2493
    static class Pair {
        int idx;
        int height;

        public Pair(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String height[] = br.readLine().split(" ");
        Stack<Pair> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < n; i++) {
            // 현재 보고있는 탑보다 높이가 낮거나 같은 탑을 스택에서 모두 제거
            while(!stack.isEmpty() && stack.peek().height <= Integer.parseInt(height[i])) {
                stack.pop();
            }
            // 스택에서 탑들을 제거한 뒤, 스택이 비어있으면 현재 보고있는 탑의 신호를 수신할 수 있는 탑이 존재하지 않음
            if(stack.isEmpty()) {
                ans.append("0 ");
            } else {
                ans.append(stack.peek().idx + " ");
            }
            stack.push(new Pair(i+1, Integer.parseInt(height[i])));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
