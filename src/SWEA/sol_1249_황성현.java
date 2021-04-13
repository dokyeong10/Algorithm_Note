package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class sol_1249_황성현 {
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static char[][] map;
    static int[][] times;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws Exception {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.valueOf(bf.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(bf.readLine());

            map = new char[N][];
            for (int r = 0; r < N; r++) {
                map[r] = bf.readLine().toCharArray();
            }
            times = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    times[r][c] = Integer.MAX_VALUE;
                }
            }

            bfs();

            sb.append('#').append(testCase).append(' ').append(times[N-1][N-1]).append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(0, 0));
        times[0][0] = map[0][0] - '0';

        while (!q.isEmpty()) {
            Point cur = q.poll();

            int r = cur.r;
            int c = cur.c;

            int nr, nc;
            for (int[] d : dir) {
                nr = r + d[0];
                nc = c + d[1];

                if(!check(nr, nc)) continue;
                if(times[nr][nc] > times[r][c] + (map[nr][nc] - '0')) {
                    times[nr][nc] = times[r][c] + (map[nr][nc] - '0');
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        if(r < 0 || c < 0 || r > N - 1 || c > N - 1) return false;
        return true;
    }

}
