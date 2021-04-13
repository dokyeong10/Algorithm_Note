package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18405_경쟁적전염 {
    static int N, K, S, X, Y;
    static int map[][];
    static int check[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<>();
    static ArrayList<Point> viruslist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 배열 크기
        K = Integer.parseInt(st.nextToken()); // 바이러스 번호
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    viruslist.add(new Point(i, j, map[i][j]));
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(viruslist, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.num - o2.num;
            }
        }); // 정렬

        for (int i = 0; i < viruslist.size(); i++) {
            q.offer(viruslist.get(i));
        } // 큐에 담기
        int time = 0;
        while (!q.isEmpty()) {
            if (time == S) break;
            int size = q.size();
            while (size-- > 0) {
                Point cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                int nr, nc;
                for (int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];
                    if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
                    if (map[nr][nc] != 0) continue;
                    map[nr][nc] = map[r][c];
                    q.offer(new Point(nr, nc));
                }
            }
            time++;
        }
        System.out.println(map[X][Y]);


    } // end of main

    private static void bfs() {
        q.offer(new Point(0, 0));
    }
    static class Point {
        int r, c, num;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
} // end of class
