package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SEWA_5656_벽돌_태희쌤3 {

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, W, H, min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            go(0, map); //구슬 떨어뜨리기
            System.out.println("#" + test_case + " " + min);


        } // end of tc
    }// end of main

    //중복순열로 구슬 떨어뜨리기
    private static void go(int cnt, int[][] map) { //cnt : 구슬을 떨어드린 횟수, map : cnt-1 구슬까지의 상태맵

        if (cnt == N) {
            int result = getRemain(map);
            min = Math.min(min, result);
            return;
        }

        int[][] newMap = new int[H][W];

        //매열마다 구슬 떨어뜨리는 시도 
        for (int c = 0; c < W; c++) {
            // 해당열에 구슬을 떨어뜨려 맞는 벽돌 찾기
            int r = 0;
            while (r < H && map[r][c] == 0) ++r;
            if (r == H) { //맞는 벽돌 없음 (모두 빈칸)
                go(cnt + 1, map);

            } else {
                // 기존 cnt-1 구슬까지의 상태로 초기화
                copy(map, newMap);
                //벽돌 깨뜨리기
                boom(newMap, r, c);
                // 벽돌 내리기 (깨지고 난 빈 공간 처리)
                down(newMap);
                //다음 구슬 던지기
                go(cnt + 1, newMap);
            }
        }
    }

    private static int getRemain(int[][] map) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] > 0) ++count;
            }
        }
        return count;
    }

    private static ArrayList<Integer> list = new ArrayList<Integer>();

    private static void down(int[][] map) {
        for (int c = 0; c < W; c++) {
            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] > 0) { //벽돌 이면
                    list.add(map[r][c]);
                    map[r][c] = 0;
                }
            } // 벽돌 리스트에 넣기
            int r = H;
            for (int b : list) { //리스트에 담긴 벽돌 차례대로 꺼내어 맨 아래행부터 채우기
                map[--r][c] = b;
            }
            list.clear();
        }
    }


    private static void boom(int[][] map, int r, int c) {
        Queue<Point> queue = new LinkedList<Point>();
        if (map[r][c] > 1) {
            queue.offer(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0; //제거 처리 (방문 처리 효과)

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r;
                int nc = p.c;
                for (int k = 1; k < p.cnt; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
                        if (map[nr][nc] > 1) {
                            queue.offer(new Point(nr, nc, map[nr][nc]));
                        }
                        map[nr][nc] = 0;
                    }
                }
            }
        }


    }

    private static void copy(int[][] map, int[][] newMap) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                newMap[i][j] = map[i][j];
            }
        }

    }
} // end of class
