import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[][] maze, dis;
    static Queue<Point> fireQ;
    static Queue<Point> jhQ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // R, C 읽어오기
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        fireQ = new LinkedList<>();
        jhQ = new LinkedList<>();
        maze = new String[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                maze[i][j] = String.valueOf(str.charAt(j));

                if(maze[i][j].equals("F")) {
                    fireQ.add(new Point(i, j));
                }
                else if(maze[i][j].equals("J")) {
                    jhQ.add(new Point(i, j));
                }
            }
        }

        String answer = BFS();

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static String BFS() {

        // 탈출 시간
        int count = 0;

        while (!jhQ.isEmpty()) {
            // 불 퍼짐
            int fireSize = fireQ.size();
            for (int i = 0; i < fireSize; i++) {
                Point temp = fireQ.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];

                    if (nx >= 0 && nx < maze.length && ny >= 0
                        && ny < maze[0].length && (maze[nx][ny].equals(".") || maze[nx][ny].equals("J"))) {
                        maze[nx][ny] = "F";
                        fireQ.add(new Point(nx, ny));
                    }
                }
                fireQ.add(temp);
            }


            // 지훈 움직임
            Point jihoon = jhQ.poll();

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = jihoon.x + dx[i];
                int ny = jihoon.y + dy[i];

                if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) {
                    return String.valueOf(++count);
                } else if (nx >= 0 && nx < maze.length && ny >= 0
                           && ny < maze[0].length && maze[nx][ny].equals(".")) {
                    maze[nx][ny] = "J";
                    jhQ.add(new Point(nx, ny));
                    count++;
                }
            }

//            System.out.println(Arrays.deepToString(maze));
//            System.out.println();
//            System.out.println();
        }

        return "IMPOSSIBLE";
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