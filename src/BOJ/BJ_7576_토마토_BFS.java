package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 하루 지나면 인접 토마토 - 익음
 * 4방 , 최소 일수 , 모든게 다 익는데 며칠? ( 다 익는게 불가능하면 -1 출력 )
 *
 * */
public class BJ_7576_토마토_BFS {
    static int N, M, tomato[][];

    static int dr[] = {-1, 1, 0, 0};// 상하좌우
    static int dc[] = {0, 0, -1, 1};// 상하좌우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); //열
        N = Integer.parseInt(st.nextToken()); //행

        tomato = new int[N][M];

        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if (tomato[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }// 입력 받기 완료 //

        int result = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1) continue;
                if (tomato[nr][nc] == -1 || tomato[nr][nc] == 1) continue;
                tomato[nr][nc] = tomato[r][c] + 1;
                q.offer(new Point(nr, nc));

            }
            result = tomato[r][c];
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(result - 1);
        }
    } // end of main

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

} // end of class