import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // {키, 연속 같은 키 사람}
        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        // 쌍의 수
        int pair = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 1;

            while (!stack.isEmpty() && stack.peek()[0] < num) {
                int[] top = stack.pop();
                pair += top[1];
            }

            //스택에 키 같은 사람이 있는 경우
            if (!stack.isEmpty() && stack.peek()[0] == num) {
                int[] top = stack.pop();
                pair += top[1];
                count += top[1];
            }

            if (!stack.isEmpty()) {
                pair++;
            }

            int[] push = {num, count};
            stack.push(push);

        }

        bw.write(pair +"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}