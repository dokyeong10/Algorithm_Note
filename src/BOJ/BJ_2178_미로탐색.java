package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {
    static int N, M;
    static int[][] map;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int check[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        } /// 입력 받기 완료 ///
        int result = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));

        check[0][0] = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (check[nr][nc] > 0) continue;
                if (map[nr][nc] == 0) continue;
                check[nr][nc] = check[r][c] + 1;
                q.offer(new Point(nr, nc));
                result = Math.max(result, check[nr][nc]);
                if (nr == N - 1 && nc == M - 1)
                    break;
            }
        }
        System.out.println(check[N - 1][M - 1]);


    }// end of main

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
