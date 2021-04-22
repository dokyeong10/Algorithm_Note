package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_1868_파핑파핑지뢰찾기_DFS {

    static int N, bomb[][];
    static char[][] map;
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 상우 우 우하 하 하좌 좌 상좌
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            bomb = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            } // 문자열입력 받기 완료 //

// 주변 지뢰 개수 찾기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '.') {
                        int cnt = 0;
                        int nr, nc;
                        for (int d = 0; d < 8; d++) {
                            nr = r + dr[d];
                            nc = c + dc[d];
                            if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1 || map[nr][nc] != '*') continue;
                            cnt++;
                        }
                        bomb[r][c] = cnt;
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (bomb[i][j] == 0 && map[i][j] != '*') {
                        dfs(i, j);
                        result++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (bomb[i][j] > 0 && map[i][j] != '*') {
                        result++;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(result).append("\n");

        }// end of tc
        System.out.println(sb);

    } // end of main

    private static void dfs(int r, int c) {
        int cur = bomb[r][c];
        bomb[r][c] = -1;

        if (cur == 0) {
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1 || bomb[nr][nc] == -1 || map[nr][nc] == '*') continue;
                dfs(nr, nc);

            }
        }


    } // end of bfs

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

} // end of class
