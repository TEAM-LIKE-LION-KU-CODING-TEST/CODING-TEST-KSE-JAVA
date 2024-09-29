import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        int maxSize = 0;

        String[] size = br.readLine().split(" ");
        int height = Integer.parseInt(size[0]);
        int width = Integer.parseInt(size[1]);

        int[][] canvas = new int[height][width];
        for (int i = 0; i < height; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < width; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int currSize = 0;
                if (!visited[i][j] && canvas[i][j] == 1) {
                    count++;
                    currSize = DFS(i, j, canvas, visited, currSize);
                }
                if (maxSize < currSize) maxSize = currSize;
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int DFS(int h, int w, int[][] canvas, boolean[][] visited, int size) {
        visited[h][w] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 상하좌우 이동
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            // 배열 범위 내에 있고, 아직 방문하지 않았으며, 그 칸이 1일 때 DFS 호출
            if (nx >= 0 && nx < canvas.length && ny >= 0 && ny < canvas[0].length) {
                if (!visited[nx][ny] && canvas[nx][ny] == 1) {
                    size = DFS(nx, ny, canvas, visited, size); // 재귀 호출
                }
            }
        }

        return ++size;
    }
}