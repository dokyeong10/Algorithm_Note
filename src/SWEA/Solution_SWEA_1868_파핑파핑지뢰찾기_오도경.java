package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1868_파핑파핑지뢰찾기_오도경 {
    static int N, Cnt[][];
    static char[][] map;
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 상우 우 하우 하 하좌 좌 좌상
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1}; //(상부터 시계방향)
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= TC; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            Cnt = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            } //입력 받기 완료//

            // 클릭 할 수 있는 곳의 주변 지뢰 개수 세기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '.') {
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1 || map[nr][nc] != '*') continue;
                            cnt++;
                        }
                        Cnt[r][c] = cnt;
                    }
                }
            }

            int result = 0;
            // 주변에 지뢰가 아에 없는 곳
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Cnt[i][j] == 0 && map[i][j] != '*') {
                        bfs(i, j);
                        result++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Cnt[i][j] > 0 && map[i][j] != '*') {
                        result++;
                    }
                }
            }


            sb.append("#").append(test_case).append(" ").append(result).append("\n");

        }// end of tc
        System.out.println(sb);


    } // end of main

    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        Cnt[r][c] = -1; // 안쓰는 값으로 바꾼다

        while (!q.isEmpty()) {
            Point cur = q.poll();

            int nr, nc;
            //  cnt =Math.min(cnt,)
            for (int d = 0; d < 8; d++) {
                nr = cur.r + dr[d];
                nc = cur.c + dc[d];
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) continue;
                if (map[nr][nc] == '*') continue;

                if (Cnt[nr][nc] == 0) {
                    q.offer(new Point(nr, nc));
                }
                Cnt[nr][nc] = -1;


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
