import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17298 {
    // p17298
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];
        Stack<Integer> stack = new Stack<>();   // stack에는 index 저장

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 0; i < n; i++) {
            // 현재 보고있는 수보다 작은 수는 stack에서 pop
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                // stack에서 현재 원소에 의해 pop되는 원소는 현재 원소를 오큰수로 가짐
                nums[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        // 위 과정을 모두 거치고도 stack에 남아있는 수들은 오큰수를 갖지 않는 수
        while(!stack.isEmpty()) {
            nums[stack.pop()] = -1;
        }

        // 정답 출력.
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) {
            ans.append(nums[i] + " ");
        }
        System.out.print(ans.toString());
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
