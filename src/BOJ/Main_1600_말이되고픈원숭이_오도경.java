package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이_오도경 {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1}; // 상하 좌우
    static int h_dr[] = {-2, -1, -2, -1, 1, 2, 2, 1}; //나이트 방향
    static int h_dc[] = {-1, -2, 1, 2, 2, 1, -1, -2}; //
    static int K, row, col;
    static int map[][];
    static int[][][] visited; // [r][c][jump]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine()); //나이트형식으로 이동 가능한 수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken()); // 열
        col = Integer.parseInt(st.nextToken()); //행

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(bfs());
        }// 입력 받기 완료//
    } // end of main
        static int bfs() {
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(0, 0, 0));
            while (!q.isEmpty()) {
                Point cur = q.poll();
                Point nxt;
                for (int i = 0; i < 12; i++) {
                    if (i < 4) { // 4
                        nxt = new Point(cur.r + dr[i], cur.c + dc[i], cur.jump);
                    } else { // horse
                        nxt = new Point(cur.r + h_dr[i - 4], cur.c + h_dc[i - 4], cur.jump + 1);
                    }
                    // out of range
                    if (nxt.r >= row || nxt.r < 0 || nxt.c >= col || nxt.c < 0) continue;
                    // visit
                    if (map[nxt.r][nxt.c] == 1) continue; // 장애물일 경우
                    if (visited[nxt.r][nxt.c][nxt.jump] != 0) continue; //이미 방문 한경우
                    q.offer(nxt);
                    visited[nxt.r][nxt.c][nxt.jump] = visited[cur.r][cur.c][cur.jump] + 1;
                    if (nxt.r == row - 1 && nxt.c == col - 1) {
                        return visited[nxt.r][nxt.c][nxt.jump] - 1;
                    }

                }
            }


            return -1; //불가능할 경우
        }


    static class Point {
        int r, c, jump;

        public Point(int r, int c, int jump) {
            this.r = r;
            this.c = c;
            this.jump = jump;
        }
    }
} // end of class
