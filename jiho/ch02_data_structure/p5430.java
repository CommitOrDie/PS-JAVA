package ch02_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class p5430 {
    // ch02_data_structure.p5430
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            char command[] = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            // 입력 값 전처리
            input = input.substring(1, input.length() - 1);
            String[] nums = input.split(",");
            Deque<String> deque = new ArrayDeque<>();

            for(int j = 0; j < n; j++) {
                deque.addLast(nums[j]);
            }

            // 입력받은 함수 실행
            boolean isRevered = false;
            boolean isError = false;
            for(int j = 0; j < command.length; j++) {
                if(command[j] == 'R') {
                    isRevered = !isRevered;
                } else {
                    if(deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    // 이전에 R을 만난 경우, 뒤에서부터 원소 제거(뒤집은 효과)
                    if(isRevered) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            // 정답 출력
            StringBuilder ans = new StringBuilder();
            if(isError) {
                ans.append("error");
            } else {
                int size = deque.size();
                ans.append("[");
                if(isRevered) {
                    for(int j = 0; j < size - 1; j++) {
                        ans.append(deque.removeLast() + ",");
                    }
                } else {
                    for(int j = 0; j < size - 1; j++) {
                        ans.append(deque.removeFirst() + ",");
                    }
                }
                if(!deque.isEmpty()) {
                    ans.append(deque.remove());
                }
                ans.append("]");
            }
            System.out.println(ans.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
