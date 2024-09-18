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
        int M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N; i > 0; i--) {
            deque.addFirst(i);
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {

            int index = 0;

            // 타겟 위치 찾기
            for (int num : deque) {
                if (num == arr[i]) break;
                index++;
            }

            // 2번 연산
            if(index <= deque.size() / 2) {
                answer += index;
                while (arr[i] != deque.peek())
                    deque.addLast(deque.remove());
            }
            // 3번 연산
            else {
                answer += (deque.size() - index);
                while (arr[i] != deque.peek())
                    deque.addFirst(deque.removeLast());
            }

            deque.removeFirst();
        }

        System.out.println(answer);
    }
}