package SWEA;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_보급로_서울_10_오도경 {
    static int N;
    static int map[][];
    static int times[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            times = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    times[i][j] = Integer.MAX_VALUE;
                }
            } //// 입력받기 ////

            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(0, 0));
            times[0][0]=map[0][0];

            while (!q.isEmpty()) {
                Point cur = q.poll();

                int r = cur.r;
                int c = cur.c;

                int nr, nc;
                for (int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if (times[nr][nc] > times[r][c] + map[nr][nc]) {
                        times[nr][nc] = times[r][c] + map[nr][nc];
                        q.add(new Point(nr, nc));
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(times[N - 1][N - 1]).append('\n');
        }// end of tc
        System.out.println(sb);
    } //end of main

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} // end of class
