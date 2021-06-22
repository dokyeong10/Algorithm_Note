package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16918_봄버맨 {
    static int R, C, N;
    static int[][] map;
    static Queue<Point> q = new LinkedList<>();
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '.') map[i][j] = -1; // 빈공간
                else map[i][j] = 2; // 폭탄 처음에 1초 지남
            }
        }
        for (int time = 1; time < N; time++) {
            //print();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == -1) map[i][j] = 3;
                    else map[i][j]--;
                    if (map[i][j] == 0)
                        q.offer(new Point(i, j));
                }
            }
            while (!q.isEmpty()) {
                Point cur = q.poll();
                map[cur.r][cur.c] = -1;

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (nr < 0 || nc < 0 || nr > R - 1 || nc > C - 1) continue;
                    map[nr][nc] = -1;

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    sb.append('O');
                else sb.append('.');
            }
            sb.append('\n');
        }
        System.out.println(sb);


    } // end of main

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} // end of class
