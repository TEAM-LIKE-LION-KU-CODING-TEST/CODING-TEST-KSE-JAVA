import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] board, dis;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N, M 읽어오기
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        board = new int [N][M];
        dis = new int [N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(Arrays.deepToString(board));

        BFS(0, 0);

        bw.write(dis[N-1][M-1] + "");

        bw.flush();
        bw.close();
        br.close();
    }


    public static void BFS(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        board[x][y] = 1;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                    board[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                }
            }
        }
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

