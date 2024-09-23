import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        int answer = 1;

        Character last = null;

        for (int i = 0; i < str.length(); i++) {

            Character token = str.charAt(i);

            switch (token) {
                case '(':
                    stack.push(token);
                    break;

                case ')' :
                    if(stack.peek() == '(')
                        stack.pop();
                    else {
                        bw.write("0");
                        bw.flush();
                        System.exit(0);
                    }
                    answer *= 2;
                    break;

                case '[':
                    stack.push(token);
                    break;

                case ']':
                    if(stack.peek() == '[')
                        stack.pop();
                    else {
                        bw.write("0");
                        bw.flush();
                        System.exit(0);
                    }
                    answer *= 3;
                    break;
            }

            last = token;
        }

        if (!stack.isEmpty()) answer = 0;

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}