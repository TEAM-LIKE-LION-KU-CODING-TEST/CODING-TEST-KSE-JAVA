import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[][] lake;
    static Queue<Point> q;
    static Queue<Point> swan;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // R, C 읽어오기
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        lake = new String [R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                lake[i][j] = String.valueOf(str.charAt(j));

                if(lake[i][j].equals("x")) {
                    q.add(new Point(i, j));
                }
                else if(lake[i][j].equals("L")) {
                    swan.add(new Point(i, j));
                }
            }
        }

        BFS();
    }

    public static void BFS() {

        Queue<Point> q = new LinkedList<>();

        Point temp = q.poll();

        // 상하좌우 이동
        for (int i = 0; i < 4; i++) {
            int nx = temp.x + dx[i];
            int ny = temp.y + dy[i];


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