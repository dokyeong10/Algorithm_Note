package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1926_그림 {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int N, M, paper[][];
    static boolean check[][];
    static int size = 0, maxsize = 0;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] == 1 && !check[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(size);
        System.out.println(maxsize);
    } // end of main

    private static void bfs(int r, int c) {
        q = new LinkedList<>();
        q.offer(new Point(r, c));
        int cnt = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr > N - 1 || nc > M - 1 || nr < 0 || nc < 0) continue;
                if (paper[nr][nc] == 0) continue;
                if (check[nr][nc]) continue;
                check[nr][nc] = true;
                q.offer(new Point(nr, nc));
            }
        }
        size++;
        if (cnt > 1) {
            cnt--;
        }
        maxsize = Math.max(maxsize, cnt);


    }
} // end of class
class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

