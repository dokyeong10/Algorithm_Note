package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {
    static int N, M, map[][], copymap[][], max, safety;
    static boolean check[][], Qcheck[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copymap = new int[N][M];
        check = new boolean[N][M];
        Qcheck = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 받기 완료
        max = Integer.MIN_VALUE;
        comb(0);
        System.out.println(max);
    } // end of main

    private static void comb(int num) {
        if (num == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copymap[i][j] = map[i][j];
                    if (map[i][j] == 2) {
                        Qcheck[i][j] = true;
                        q.offer(new Point(i, j));
                    }
                }
            }
            Spread();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    Qcheck[i][j] = false;
                }
            }
            safety = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copymap[i][j] == 0)
                        safety++;
                }
            }
            max = Math.max(safety, max);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !check[i][j]) {
                    map[i][j] = 1;
                    check[i][j] = true;
                    comb(num + 1);
                    map[i][j] = 0;
                    check[i][j] = false;
                }
            }
        }
    }

    private static void Spread() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int nr, nc;
            Qcheck[r][c] = true;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1) continue;
                if (copymap[nr][nc] == 1) continue;
                if (copymap[nr][nc] == 2) continue;
                if (Qcheck[nr][nc]) continue;
                copymap[nr][nc] = 2;
                Qcheck[nr][nc] = true;
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
}// end of class
