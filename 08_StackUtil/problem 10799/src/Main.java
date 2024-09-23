import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        // push -> pop("()") 이 일어나는지 확인하는 깃발
        // flag == 1일 때 pop => 레이저
        // flag == 0일 때 pop => 쇠막대기 끝
        int flag = 0;
        // 쇠막대기 조각의 수
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {

            Character token = str.charAt(i);

            switch (token) {
                case '(':
                    stack.push(token);
                    if(flag == 0) flag++;
                    break;

                case ')':
                    stack.pop();
                    if(flag == 1) {
                        answer += stack.size();
                        flag = 0;
                    }
                    else {
                        answer++;
                    }
                    break;
            }

        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}