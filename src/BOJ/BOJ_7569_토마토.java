package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
    static int M, N, map[][][], H, max = -2, result;
    static int dr[] = {0, 0, 0, 0, -1, 1};
    static int dc[] = {0, 0, -1, 1, 0, 0};
    static int dz[] = {-1, 1, 0, 0, 0, 0};
    static int check[][][];
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken());// 높이
        map = new int[H][N][M];
        check = new int[H][N][M];
        boolean flag = false;
        for (int w = 0; w < H; w++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[w][i][j] = Integer.parseInt(st.nextToken());
                    if (map[w][i][j] == 1 && check[w][i][j] == 0) {
                        check[w][i][j] = 1;
                        q.offer(new Point(w, i, j));
                    } else if (map[w][i][j] == 0) {
                        flag = true;
                    } else if (map[w][i][j] == -1) {
                        check[w][i][j] = -1;
                    }
                }
            }
        }
        BFS();
        for (int w = 0; w < H; w++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    max = Math.max(max, check[w][i][j]);
                    if (check[w][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println(0);
        } else {
            System.out.println(max - 1);
        }
    }// end of main
    private static void BFS() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int z = cur.z;
            int r = cur.r;
            int c = cur.c;
            int nr, nc, nz;
            for (int d = 0; d < 6; d++) {
                nz = z + dz[d];
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1 || nz < 0 || nz > H - 1) continue;
                if (map[nz][nr][nc] == 1 || map[nz][nr][nc] == -1) continue;
                if (check[nz][nr][nc] > 0) continue;
                check[nz][nr][nc] = check[z][r][c] + 1;
                q.offer(new Point(nz, nr, nc));
            }
        }
    }
    static public class Point {
        int z, r, c;

        public Point(int z, int r, int c) {
            this.z = z;
            this.r = r;
            this.c = c;
        }
    }
} // end of class
