import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int word[] = new int[26];

        String str1 = br.readLine();
        for (int j = 0; j < str1.length(); j++) {
            char token = str1.charAt(j);
            word[(int)token - 97]++;
        }

        String str2 = br.readLine();
        for (int j = 0; j < str2.length(); j++) {
            char token = str2.charAt(j);
            word[(int)token - 97]--;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(word[i]);
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}