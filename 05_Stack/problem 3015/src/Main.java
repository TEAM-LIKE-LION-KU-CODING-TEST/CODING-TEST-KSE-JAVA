import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        int pair = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(stack.isEmpty())
                stack.push(num);
            else if (stack.peek() < num) {
                stack.pop();
                stack.
            }
        }

        bw.write(pair +"");

        bw.flush();
        bw.close();
        br.close();
    }
}