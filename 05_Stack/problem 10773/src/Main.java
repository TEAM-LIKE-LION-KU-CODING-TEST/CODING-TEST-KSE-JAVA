import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        stack.add(0);

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) stack.pop();
            else stack.add(num);
        }

        int sum = 0;
        for (int i : stack)
            sum += i;

        bw.write(sum + "");

        bw.flush();
        bw.close();
        br.close();
    }
}