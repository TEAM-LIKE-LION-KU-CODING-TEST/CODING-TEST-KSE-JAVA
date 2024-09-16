import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // top 길이 저장 (String)
        String[] str = br.readLine().split(" ");
        int[] top = new int[N];

        for(int i = 0; i < N; i++) {
            top[i] = Integer.parseInt(str[i]);
        }

        // stack 담기
        // {탑 번호, 높이}
        Stack<int[]> s = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {

            // top보다 큰 새 값이 들어올 경우 top을 pop 하고 새 값 넣음
            while (!s.isEmpty() && s.peek()[1] < top[i]) {
                s.pop();
            }

            if(!s.isEmpty()) answer.append(s.peek()[0]).append(" ");
            else answer.append("0 ");

            s.add(new int[]{i + 1, top[i]});

        }

        bw.write(answer.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}