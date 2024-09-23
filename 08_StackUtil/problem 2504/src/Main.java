import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        int temp = 0;

        for (int i = 0; i < str.length(); i++) {

            char token = str.charAt(i);

            switch (token) {
                case '(':
                    stack.push(token);
                    System.out.println(stack);
                    break;

                case ')' :
                    while(!stack.isEmpty() && (stack.peek() != '(' || stack.peek() != '[')) {
                       temp += Character.getNumericValue(stack.pop());
                    }
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        if(temp == 0) temp++;
                        stack.pop();
                        stack.push((char) (temp * 2));
                    }
                    else {
                        bw.write("0");
                        bw.flush();
                        System.exit(0);
                    }
                    System.out.println(stack);
                    break;

                case '[':
                    stack.push(token);
                    System.out.println(stack);
                    break;

                case ']':
                    while(!stack.isEmpty() && (stack.peek() != '(' || stack.peek() != '[')) {
                        temp += Character.getNumericValue(stack.pop());
                    }
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        if(temp == 0) temp++;
                        stack.pop();
                        stack.push((char) (temp * 3));
                    }
                    else {
                        bw.write("0");
                        bw.flush();
                        System.exit(0);
                    }
                    System.out.println(stack);
                    break;
            }
        }

        if (!stack.isEmpty()) temp = 0;

        bw.write(temp + "");

        bw.flush();
        bw.close();
        br.close();
    }
}