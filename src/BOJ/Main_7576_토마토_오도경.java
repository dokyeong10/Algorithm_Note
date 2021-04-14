package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_오도경 {

    static int N, M;
    static int farm[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //열
        M = Integer.parseInt(st.nextToken()); // 행

        farm = new int[M][N];

        int toma = 0; // 안익은 토마토 개수

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
                if (farm[i][j] == 1) {
                    q.offer(new Point(i, j));
                } else if (farm[i][j] == 0) {

                    toma++; // 안익은 토마토 개수

                }
            }
        } // 입력 받기 완료 //

        if (toma == 0) { /// 처음부터 토마토가 다 익어있으면
            System.out.println(0);
            return;

        }
        int cnt = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            int nr, nc;

            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                if (farm[nr][nc] == -1) continue;
                if (farm[nr][nc] > 0) continue;

                farm[nr][nc] = farm[r][c] + 1;
                toma--;
                q.offer(new Point(nr, nc));
            }
           cnt =Math.max(farm[r][c],cnt);
        }

        if (toma == 0) { // 안익은게 없으면
            System.out.println(cnt - 1); //1부터 시작해서

        } else {
            System.out.println(-1); // 다 못익으면
            return;

        }
    } // end of main

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} //end of class
