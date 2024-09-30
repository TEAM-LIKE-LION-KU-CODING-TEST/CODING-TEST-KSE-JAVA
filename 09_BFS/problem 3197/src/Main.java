import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[][] lake;
    static Queue<Point> ice;
    static Queue<Point> swan;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // R, C 읽어오기
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        lake = new String [R][C];
        ice = new LinkedList<>();
        swan = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                lake[i][j] = String.valueOf(str.charAt(j));

                if(lake[i][j].equals("X")) {
                    ice.add(new Point(i, j));
                }
                else if(lake[i][j].equals("L")) {
                    swan.add(new Point(i, j));
                }
            }
        }

        BFS();
    }

    public static void BFS() {

        Queue<Point> melt = new LinkedList<>();
        while(!ice.isEmpty()) {

            int iceSize = ice.size();
            for (int l = 0; l < iceSize; l++) {

                Point temp = ice.poll();
                Boolean isMelt = false;

                // 상하좌우 이동
                for (int i = 0; i < 4; i++) {

                    int nx = temp.x + dx[i];
                    int ny = temp.y + dy[i];

                    if (nx >= 0 && nx < lake.length && ny >= 0
                        && ny < lake[0].length && lake[nx][ny].equals(".")) {
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

            String str = "";
            for (int x = 0; x < lake.length; x++) {
                for (int y = 0; y < lake[0].length; y++) {
                    str += lake[x][y];
                }
                str += "\n";
            }
            System.out.println(str);
            System.out.println();
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