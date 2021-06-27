package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
    static int N, M, cheese[][], cnt;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();
    static boolean check[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];
        check = new boolean[N][M];
        cnt = 0;
        int ch_num = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) {
                    ch_num++;
                }
            }
        }/// 입력받기 완료
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheese[i][j] == 0 && (i == 0 || j == 0 || i == N - 1 || j == M - 1) && !check[i][j]) {
                    check[i][j] = true;
                    cheese[i][j] = 2;
                    q.offer(new Point(i, j));

                }
            }
        }
        BFS_Ze();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(cheese[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        while (ch_num > 0) {
            result++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (check[i][j]) check[i][j] = false;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cheese[i][j] == 1) {
                        int ni, nj;
                        for (int d = 0; d < 4; d++) {
                            ni = i + dr[d];
                            nj = j + dc[d];
                            if (ni < 0 || nj < 0 || ni > N - 1 || nj > M - 1) continue;
                            if (check[ni][nj]) continue;
                            if (cheese[ni][nj] == 2) {
                                cheese[i][j] = 2;
                                check[i][j] = true;
                                ch_num--;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(cheese[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();


        }
        System.out.println(result);


    } // end of main

    private static void BFS_Ze() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            check[r][c] = true;

            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1) continue;
                if (cheese[nr][nc] == 1 || check[nr][nc]) continue;
                cheese[nr][nc] = 2;
                check[nr][nc] = true;
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
