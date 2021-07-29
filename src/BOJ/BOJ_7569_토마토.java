package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
    static int M, N, map[][], H, max = -2;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int dh[] = {-1, 1};
    static int check[][];
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken());// 높이
        map = new int[N * H][M];
        check = new int[N * H][M];
        boolean flag = false;
        int result = -2;
        int cnt = 0;
        for (int i = 0; i < N * H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) flag = true;
                if (map[i][j] == -1) {
                    check[i][j] = -1;
                }
                if (map[i][j] == 1 && check[i][j] == 0) {
                    q.offer(new Point(i, j));
                    check[i][j] = 1;

                }
            }
        }
        BFS();
        for (int i = 0; i < N * H; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(check[i][j] + " ");
                if (check[i][j] == 0) {
                    result = -1;
                    System.out.println(result);
                    return;
                }
            }
            System.out.println();
        }
        System.out.println();
        if (!flag) {
            result = 0;
        } else {
            result = max - 1;
        }
        System.out.println(result);


    }// end of main

    private static void BFS() {
        int r, c;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            r = cur.r;
            c = cur.c;
            int nr, nc, nh;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > N * H - 1 || nc > M - 1) continue;
                if (map[nr][nc] == -1 || map[nr][nc] == 1) continue;
                if (check[nr][nc] > 0) continue;
                check[nr][nc] = check[r][c] + 1;
                max = Math.max(check[nr][nc], max);
                q.offer(new Point(nr, nc));
            }
            for (int d = 0; d < 2; d++) {
                nh = r + dh[d] * N;
                if (nh < 0 || nh > N * H - 1) continue;
                if (map[nh][c] == 1 || map[nh][c] == -1) continue;
                if (check[nh][c] > 0) continue;
                check[nh][c] = check[r][c] + 1;
                max = Math.max(check[nh][c], max);
                q.offer(new Point(nh, c));
            }


        }
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} // end of class
