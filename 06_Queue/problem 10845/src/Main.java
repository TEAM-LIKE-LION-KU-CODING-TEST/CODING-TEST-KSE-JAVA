import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int last = -1;

        for (int i = 0; i < N; i ++) {

            StringTokenizer str = new StringTokenizer(br.readLine());
            String order = str.nextToken();

            if(order.equals("push")) {
                int value = Integer.parseInt(str.nextToken());
//                bw.write(value +"\n");
                q.add(value);
                last = value;
            }
            else if(order.equals("front")) {
                if(q.isEmpty()) bw.write("-1\n");
                else bw.write(q.peek() + "\n");
            }
            else if(order.equals("back")) {
                if(q.isEmpty()) bw.write("-1\n");
                else bw.write(last+ "\n");
            }
            else if(order.equals("size")) {
                bw.write(q.size() + "\n");
            }
            else if(order.equals("empty")) {
                if (q.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(order.equals("pop")){
                if(q.isEmpty()) bw.write("-1\n");
                else bw.write(q.poll() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}