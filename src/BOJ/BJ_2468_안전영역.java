package BOJ;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {
    static int N;
    static int map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        } /// 입력 받기 완료 /// /

        int height = 0;
        int resultmax = 0; // 출력값
        int result = 0; // 높이당 크기

        Queue<Point> q = new LinkedList<>();
        int cnt[] = new int[N * N];
        int K = 0;
        while (height != max + 1) {
            for (int Q = 0; Q < N; Q++) {
                for (int W = 0; W < N; W++) {
                    if (map[Q][W] < height) {
                        visited[Q][W] = true;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (!visited[i][j]) {
                        q.offer(new Point(i, j));
                        cnt[K]++;
                        while (!q.isEmpty()) {
                            Point cur = q.poll();
                            int r = cur.r;
                            int c = cur.c;

                            int nr, nc;
                            for (int d = 0; d < 4; d++) {
                                nr = r + dr[d];
                                nc = c + dc[d];

                                if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) continue;
                                if (visited[nr][nc]) continue;

                                visited[nr][nc] = true;
                                q.offer(new Point(nr, nc));
                            }
                        }
                    }
                    K++;
                }
            }
            for (int i = 0; i < N * N; i++) {
                if (cnt[i] > 0) {
                    result++;
                }
            }
            if (result > resultmax) {
                resultmax = result;
            }

            height++;
            ///초기화 작업 ///

            result = 0;
            for (int i = 0; i < N * N; i++) {
                cnt[i] = 0;
            }
            K = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited[i][j] = false;
                }
            }
        }
        System.out.println(resultmax);

    }// end of main

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} //end of class
