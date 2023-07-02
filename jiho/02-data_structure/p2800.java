import java.io.*;
import java.util.*;

public class p2800 {
    // p2800
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Vector<String> ans = new Vector<>();
    static Vector<Integer> selected = new Vector<>();   // 선택되어 제거될 괄호쌍 번호
    static Vector<Integer> pairNum = new Vector<>();    // 해당 index에 해당하는 괄호쌍 번호
    static int pairSize = 0;
    static char input[];
    static Stack<Integer> stack = new Stack<>();

    // 전체 pairSize개의 괄호쌍 중 n개 선택
    public static void combination(int n, int cur) {
        // n개의 수가 선택된 경우
        if(selected.size() == n) {
            // 선택된 n개의 수를 괄호쌍 번호로 갖는 괄호쌍을 제외한 문자열을 정답 vector에 추가
            String curAns = "";
            for(int i = 0; i < input.length; i++) {
                if(!selected.contains(pairNum.get(i))) {
                    curAns += input[i];
                }
            }
            // 서로 다른 식만 정답으로 추가
            if(!ans.contains(curAns)) {
                ans.add(curAns);
            }
            return;
        }

        // 아직 n개의 수가 선택되지 않은 경우, 추가로 선택
        for(int i = cur; i <= pairSize; i++) {
            selected.add(i);
            combination(n, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static void solution() throws IOException {
        input = br.readLine().toCharArray();

        // 각 index에 해당하는 괄호쌍 번호 저장
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(') {
                pairSize++;
                pairNum.add(pairSize);
                stack.push(pairSize);
            } else if(input[i] == ')') {
                pairNum.add(stack.peek());
                stack.pop();
            } else {
                pairNum.add(-1);
            }
        }

        // 제거할 괄호쌍 선택
        for(int i = 1; i <= pairSize; i++) {
            combination(i, 1);
        }

        // 정답 vector 사전순 정렬 후 출력
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void main(String args[]) throws IOException {
        solution();
    }
}
