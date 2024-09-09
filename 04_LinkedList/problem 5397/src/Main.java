import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            LinkedList<String> list = new LinkedList<>();
            list.add("!");
            for (int j = 0; j < str.length(); j++) {
                String token = str.substring(j, j+1);
                int cursor = list.indexOf("!");

                if (token.equals("<")) {
                    if (cursor != 0) {
                        String temp = list.get(cursor-1);
                        list.set(cursor-1, list.get(cursor));
                        list.set(cursor, temp);
                    }
                }
                else if (token.equals(">")) {
                    if (cursor != list.size()-1) {
                        String temp = list.get(cursor + 1);
                        list.set(cursor + 1, list.get(cursor));
                        list.set(cursor, temp);
                    }
                }
                else if(token.equals("-")) {
                    if (cursor != 0) {
                        list.remove(cursor - 1);
                    }
                }
                else list.add(cursor, token);

            }
            String answer = "";
            while(list.size() > 1) {
                answer += list.removeFirst();

            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();

    }
}