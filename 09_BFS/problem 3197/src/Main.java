import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static String[][] lake;
    static Queue<Point> ice;
    static Queue<Point> swan1, swan2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // R, C 읽어오기
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        lake = new String[R][C];
        ice = new LinkedList<>();
        swan1 = new LinkedList<>();
        swan2 = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = String.valueOf(str.charAt(j));

                if (lake[i][j].equals("X")) {
                    ice.add(new Point(i, j));
                } else if (lake[i][j].equals("L")) {
                    if (swan1.isEmpty()) {
                        swan1.add(new Point(i, j));
                    } else {
                        swan2.add(new Point(i, j));
                        lake[i][j] = "S";
                    }
                }
            }
        }

        String str = "";
        for (int x = 0; x < lake.length; x++) {
            for (int y = 0; y < lake[0].length; y++) {
                str += lake[x][y];
            }
            str += "\n";
        }
        System.out.println(str);
        System.out.println();

        int ans = BFS();

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS() {

        int count = 0;

        while (true) {

            // 빙판 녹음
            iceBFS();

            // 백조 움직임
            swanBFS(swan1);
            swanBFS(swan2);


            String str = "";
            for (int x = 0; x < lake.length; x++) {
                for (int y = 0; y < lake[0].length; y++) {
                    str += lake[x][y];
                }
                str += "\n";
            }
            System.out.println(str);
            System.out.println();

            count++;

            for (int s = 0; s < swan1.size(); s++) {
                Point temp = swan1.poll();

                for (int i = 0; i < 4; i++) {

                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];

                    if (nx >= 0 && nx < lake.length && ny >= 0 && ny < lake[0].length && lake[nx][ny].equals("S")) {
                        return count;
                    }
                }
            }
        }
    }

    public static void iceBFS() {

        Queue<Point> melt = new LinkedList<>();

        int iceSize = ice.size();
        for (int l = 0; l < iceSize; l++) {

            Point temp = ice.poll();
            Boolean isMelt = false;

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {

                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < lake.length && ny >= 0 && ny < lake[0].length
                    && (lake[nx][ny].equals(".") || lake[nx][ny].equals("S") || lake[nx][ny].equals("L"))) {
                    melt.add(temp);
                    isMelt = true;
                    break;
                }
            }

            if (!isMelt) {
                ice.add(temp);
            }
        }

        while (!melt.isEmpty()) {
            Point temp = melt.poll();
            lake[temp.x][temp.y] = ".";
        }
    }


    public static void swanBFS(Queue<Point> q) {

        // 다음 날에 이동할 후보를 저장하는 큐
        Queue<Point> nextQueue = new LinkedList<>();

        while (!q.isEmpty()) {

            Point temp = q.poll();

            for (int i = 0; i < 4; i++) {

                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx >= 0 && nx < lake.length && ny >= 0 && ny < lake[0].length) {

                    if (lake[nx][ny].equals(".")) {
                        lake[nx][ny] = lake[temp.x][temp.y];
                        q.add(new Point(nx, ny));
                    }
                    // 얼음일 경우, 나중에 녹았을 때 백조가 이동할 수 있도록 저장
                    else if (lake[nx][ny].equals("X")) {
                        nextQueue.add(new Point(nx, ny));
                    }

                }
            }
        }
        // 다음날에 녹은 얼음 칸으로 백조가 이동할 수 있도록 큐에 추가
        q.addAll(nextQueue);
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