import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        // 쌍의 수
        int pair = 0;
        // stack 크기
        int size = 0;

        for (int i = 0; i < N; i++) {
            //System.out.println("pair - " + pair + "\n__");
            pair += size;

            int num = Integer.parseInt(br.readLine());

            System.out.println("size - " + size);
            while(size > 0 && stack.peek() < num) {
                System.out.println("peek - " + stack.peek());
                //System.out.println("pop - " + stack.peek());
                stack.pop();
                size--;
            }

            //System.out.println("push - " + num);
            stack.push(num);
            size++;

            System.out.println("-----------------");
        }

        bw.write(pair +"");

        bw.flush();
        bw.close();
        br.close();
    }
}