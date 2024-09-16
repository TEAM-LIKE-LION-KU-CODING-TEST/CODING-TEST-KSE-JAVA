import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // top 길이 저장 (String)
        String[] str = br.readLine().split(" ");
        int[] top = new int[str.length];

        for(int i = 0; i < str.length; i++) {
            top[i] = Integer.parseInt(str[i]);
        }

        System.out.println("Hello world!");
    }
}