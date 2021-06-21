package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468_안전영역_2 {
    static int N, rain[][], result = 0, max = 0, cnt = 0;
    static Queue<Point> q;
    static boolean check[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rain = new int[N][N];
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                rain[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(rain[i][j], max);
            }
        }

        max = max + 1;
        while (max-- > 0) {
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    check[i][j] = false;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (rain[i][j] > max && !check[i][j]) {
                        bfs(i, j);
                    }
                }
            }
        }
        System.out.println(result);


    } // end of main

    private static void bfs(int r, int c) {
        cnt++;
        q = new LinkedList<>();
        q.offer(new Point(r, c));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            r = cur.r;
            c = cur.c;
            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr > N - 1 || nc > N - 1 || nr < 0 || nc < 0) continue;
                if (rain[nr][nc] <= max) continue;
                if (check[nr][nc]) continue;
                check[nr][nc] = true;
                q.offer(new Point(nr, nc));
            }
        }
        result = Math.max(result, cnt);
    } // end of bfs

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} // end of class

