package ch02_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p2504 {
    public static void solution() throws IOException {
        // ch02_data_structure.p2504
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char input[] = br.readLine().toCharArray();
        int ans = 0;
        int val = 1;
        char prev = ' ';

        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(') {
                stack.push(input[i]);   // 여는 괄호인 경우 일단 스택에 push
                val *= 2;               // 분배법칙 이용
            } else if(input[i] == '[') {
                stack.push(input[i]);   // 여는 괄호인 경우 일단 스택에 push
                val *= 3;               // 분배법칙 이용
            } else if (input[i] == ')') {
                // 현재 입력이 닫는 괄호일 때 스택이 비어있거나, 괄호의 짝이 맞지 않으면 error
                if(stack.empty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                } else {
                    if(prev == '(') {
                        ans += val;
                    }
                    val /= 2;
                    stack.pop();
                }
            } else if (input[i] == ']') {
                // 현재 입력이 닫는 괄호일 때 스택이 비어있거나, 괄호의 짝이 맞지 않으면 error
                if(stack.empty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                } else {
                    if(prev == '[') {
                        ans += val;
                    }
                    val /= 3;
                    stack.pop();
                }
            }
            prev = input[i];
        }

        // 모든 문자를 살펴본 이후, 스택이 비어있지 않으면 잘못된 문자열
        if(!stack.empty()) {
            ans = 0;
        }
        System.out.println(ans);

    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}
