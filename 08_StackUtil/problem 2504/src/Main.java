import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        String str = br.readLine();

        int temp = 0;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {

            char token = str.charAt(i);

            switch (token) {
                case '(':
                    stack.push(-10); // '(' => -10
                    break;

                case ')' :
                    temp = 0;
                    while(!stack.isEmpty() && (stack.peek() != -10 && stack.peek() != -20)) {
                       temp += stack.pop();
                    }
                    if(!stack.isEmpty() && stack.peek() == -10) {
                        if(temp == 0) temp++;
                        stack.pop();
                        stack.push(temp * 2);
                    }
                    else {
                        bw.write("0");
                        bw.flush();
                        System.exit(0);
                    }
                    break;

                case '[':
                    stack.push(-20); // '[' => -20
                    break;

                case ']':
                    temp = 0;
                    while(!stack.isEmpty() && (stack.peek() != -10 && stack.peek() != -20)) {
                        temp += stack.pop();
                    }
                    if(!stack.isEmpty() && stack.peek() == -20) {
                        if(temp == 0) temp++;
                        stack.pop();
                        stack.push(temp * 3);
                    }
                    else {
                        bw.write("0");
                        bw.flush();
                        System.exit(0);
                    }
                    break;
            }
        }

        // 스택에 남아 있는 값을 모두 더해 최종 결과를 계산
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (value < 0) {  // 스택에 여는 괄호가 남아있으면 잘못된 입력
                bw.write("0");
                bw.flush();
                System.exit(0);
            }
            result += value;
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }
}