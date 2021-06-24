package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색_2 {
    static int N, M, map[][];
    static Queue<Point> q = new LinkedList<>();
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean check[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        } // 입력 받기 완료
        BFS(0, 0);
        System.out.println(map[N - 1][M - 1]);
    } // end of main
    private static void BFS(int r, int c) {
        q.offer(new Point(r, c));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            r = cur.r;
            c = cur.c;
            check[r][c] = true;
            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr > N - 1 || nc > M - 1 || nr < 0 || nc < 0) continue;
                if (map[nr][nc] == 0) continue;
                if (check[nr][nc]) continue;
                check[nr][nc] = true;
                map[nr][nc] = map[r][c] + 1;
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
} // end of class
