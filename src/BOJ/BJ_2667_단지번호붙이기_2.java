package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2667_단지번호붙이기_2 {
    static int N, map[][], cnt;
    static Queue<Point> q = new LinkedList<>();
    static boolean check[][];
    static int dr[] = {-1, 1, 0, 0}; // 상하좌우
    static int dc[] = {0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        cnt = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '0') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    BFS(i, j);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    } // end of main

    private static void BFS(int r, int c) {
        q.offer(new Point(r, c));
        cnt++;
        check[r][c] = true;
        map[r][c] = cnt;
        int cn = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            r = cur.r;
            c = cur.c;
            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) continue;
                if (check[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;
                map[nr][nc] = cnt;
                check[nr][nc] = true;
                cn++;
                q.offer(new Point(nr, nc));
            }
        }
        list.add(cn);
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} // end of class