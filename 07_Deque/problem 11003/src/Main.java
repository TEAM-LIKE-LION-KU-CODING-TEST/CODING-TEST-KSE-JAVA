import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int L = Integer.parseInt(str.nextToken());

        StringTokenizer A = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(A.nextToken());
        }
        Deque<Integer> deq = new ArrayDeque<>();

        String answer = "";
        for (int i = 0; i < N; i++) {

            if(!deq.isEmpty() && deq.peek() < i - L + 1) deq.removeFirst();

            while (!deq.isEmpty() && arr[i] < arr[deq.peekLast()]) {
                deq.removeLast();
            }
            deq.addLast(i);

//            int temp = Integer.parseInt(A.nextToken());
//            while (!deq.isEmpty() && temp < deq.peekLast()) {
//                deq.removeLast();
//            }
//            deq.addLast(temp);

            System.out.println(deq);
            System.out.println(arr[deq.peek()]);
            System.out.println();
        }

    }
}