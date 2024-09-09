import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            LinkedList<Character> list = new LinkedList<>();

            int cursor = 0;

            for (int j = 0; j < str.length(); j++) {
                char token = str.charAt(j);

                if (token == '<') {
                    if (cursor != 0) {
                        cursor--;
                    }
                }
                else if (token == '>') {
                    if (cursor != list.size()) {
                        cursor++;
                    }
                }
                else if(token == '-') {
                    if (cursor != 0) {
                        cursor--;
                        list.remove(cursor);
                    }
                }
                else {
                    list.add(cursor, token);
                    cursor++;
                }

            }
            StringBuilder answer = new StringBuilder();
            for (char ch : list) {
                answer.append(ch);
            }

            bw.write(answer.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}