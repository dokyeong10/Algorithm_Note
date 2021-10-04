package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16918_봄버맨_self { //봄버맨 re

    static int R, C, N, map[][];
    static Queue<Point> q = new LinkedList<>();
    static int dr[] = {-1, 1, 0, 0}; // 상하좌우
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 시간
        map = new int[R][C]; // 폭탄 배열

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '.') map[i][j] = -1; // 빈칸이면 -1 넣기
                else map[i][j] = 2;  // 폭탄이면 2넣기 (이미 1초 지남)
            }
        }
        for (int time = 1; time < N; time++) { // 시간 다해봄
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == -1) map[i][j] = 3; // 빈공간이면 3 넣기
                    else map[i][j]--; // 폭탄이었으면 -1 씩 해준다
                    if (map[i][j] == 0) { //0일때
                        q.offer(new Point(i, j)); // 큐에 저장
                    }
                }
            }
            while (!q.isEmpty()) { // 4방향 + 자기자신 터트리기
                Point cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                map[r][c] = -1;

                int nr, nc;
                for (int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];
                    if (nr < 0 || nc < 0 || nr > R - 1 || nc > C - 1) continue;
                    map[nr][nc] = -1;
                }
            }
        } // end of time
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < R; i++) { // 결과 도출
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        sb.append('O');
                    } else {
                        sb.append('.'); // -1 이면 . 출력 폭탄이 터진곳이라
                    }
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

