package programmers;

import java.util.*;

public class 게임맵최단거리 {
    public int solution(int[][] maps) {//게임맵 최단 거리
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        boolean check[][] = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        check[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int nr, nc;
            check[r][c] = true;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > n - 1 || nc > m - 1) continue;
                if (maps[nr][nc] == 0) continue;
                if (check[nr][nc]) continue;
                maps[nr][nc] = maps[r][c] + 1;
                check[nr][nc] = true;
                q.offer(new Point(nr, nc));
            }
        }
        if (maps[n - 1][m - 1] == 1) {
            answer = -1;
        } else {
            answer = maps[n - 1][m - 1];
        }


        return answer;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
