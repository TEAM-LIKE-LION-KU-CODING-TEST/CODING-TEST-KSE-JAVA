import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int word[] = new int[26];

        String str1 = br.readLine();
        String str2 = br.readLine();

        // 'a'의 아스키코드가 97
        for (int j = 0; j < str1.length(); j++) {
            char token = str1.charAt(j);
            word[(int)token - 97]++;
        }

        for (int j = 0; j < str2.length(); j++) {
            char token = str2.charAt(j);
            word[(int)token - 97]--;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += Math.abs(word[i]);
        }

        // integer 값 buffer 출력 위해 String 형태로 변환
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}