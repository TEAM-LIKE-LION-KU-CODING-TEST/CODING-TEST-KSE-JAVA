import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.remove();
            q.add(q.poll());
        }

        bw.write(q.peek() + "");

        bw.flush();
        bw.close();
        br.close();
    }
}