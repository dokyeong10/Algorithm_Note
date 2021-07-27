package programmers;

import java.util.*;

public class 카카오프렌즈컬러링북 {
    static int[][] map;
    static int[][] count;
    static int[][] pictures;
    static int M, N;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int cnt = 0, now = 0, max = 0;
    static Queue<Point> q = new LinkedList<>();

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        map = new int[m][n];
        count = new int[m][n];
        pictures = new int[m][n];
        M = m;
        N = n;
        cnt = 0;
        now = 0;
        max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                pictures[i][j] = picture[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pictures[i][j] > 0 && count[i][j] == 0) {
                    cnt++;
                    now = 1;
                    count[i][j] = 1;
                    q.offer(new Point(i, j));
                    bfs(i, j);
                    max = Math.max(max, now);
                }
            }
        }
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    } // end of main

    static void bfs(int r, int c) {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            r = cur.r;
            c = cur.c;
            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > M - 1 || nc > N - 1) continue;
                if (pictures[nr][nc] != pictures[r][c]) continue;
                if (count[nr][nc] > 0) continue;
                now++;
                count[nr][nc] = now;
                q.offer(new Point(nr, nc));
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
}
