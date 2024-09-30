import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[][] maze;
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
                        && ny < maze[0].length && maze[nx][ny].equals(".")) {
                        maze[nx][ny] = "F";
                        fireQ.add(new Point(nx, ny));
                    }
                }
            }


            // 지훈 움직임
            int jhSize = jhQ.size();
            for (int i = 0; i < jhSize; i++) {
                Point jihoon = jhQ.poll();

                // 상하좌우 이동
                for (int j = 0; j < 4; j++) {
                    int nx = jihoon.x + dx[j];
                    int ny = jihoon.y + dy[j];

                    if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) {
                        return String.valueOf(++count);
                    }

                    if (maze[nx][ny].equals(".")) {
                        maze[nx][ny] = "J";
                        jhQ.add(new Point(nx, ny));
                    }
                }
//                System.out.println("count : " + count);
//
//                String str = "";
//                for (int x = 0; x < 7; x++) {
//                    for (int y = 0; y < 7; y++) {
//                        str += maze[x][y];
//                    }
//                    str += "\n";
//                }
//                System.out.println(str);
//                System.out.println();
            }
            count++;
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