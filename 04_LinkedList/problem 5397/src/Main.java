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

            list.add('!');
            int cursor = 0;

            for (int j = 0; j < str.length(); j++) {
                char token = str.charAt(j);

//                System.out.println("cursor : " + cursor);
                if (token == '<') {
                    if (cursor != 0) {
                        char temp = list.get(cursor-1);
                        list.set(cursor-1, list.get(cursor));
                        list.set(cursor, temp);
                        cursor--;
                    }
                }
                else if (token == '>') {
                    if (cursor != list.size()-1) {
                        char temp = list.get(cursor + 1);
                        list.set(cursor + 1, list.get(cursor));
                        list.set(cursor, temp);
                        cursor++;
                    }
                }
                else if(token == '-') {
                    if (cursor != 0) {
                        list.remove(cursor - 1);
                        cursor--;
                    }
                }
                else {
                    list.add(cursor, token);
                    cursor++;
                }

//                System.out.println("list: " + list + "\n");
            }
            list.remove(list.indexOf('!'));
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