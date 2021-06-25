package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5547_일루미네이션 {
    static int W, H, map[][], cnt, len;
    static int odd_dr[] = {-1, 0, 1, 1, 0, -1}; // 상  우  하
    static int odd_dc[] = {0, 1, 0, -1, -1, -1}; // 하좌 좌 우좌
    static int even_dr[] = {-1, -1, 0, 1, 1, 0}; // 상 상우 우 우하 하
    static int even_dc[] = {0, 1, 1, 1, 0, -1}; //  좌

    static Queue<Point> q = new LinkedList<>();
    static boolean check[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken()); // 열
        H = Integer.parseInt(st.nextToken()); // 행
        map = new int[H][W];
        cnt = 0;
        len = 0;
        check = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0 && (i == 0 || j == 0 || i == H - 1 || j == W - 1)) {
                    q.offer(new Point(i, j));
                    check[i][j] = true;
                }
            }
        } // 입력 받기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 1) {
                    int ni = 0, nj = 0;
                    for (int d = 0; d < 6; d++) {
                        if (i % 2 == 0) {
                            ni = i + even_dr[d];
                            nj = j + even_dc[d];
                        } else if (i % 2 != 0) {
                            ni = i + odd_dr[d];
                            nj = j + odd_dc[d];
                        }
                        if (ni < 0 || nj < 0 || ni > H - 1 || nj > W - 1) continue;
                        if (map[ni][nj] == 0) continue;
                        cnt++;
                    }
                    len += 6 - cnt;
                    cnt = 0;
                }
            }
        }
        BFS();
        int zero = 0, zero_len = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    int nni = 0, nnj = 0;
                    for (int d = 0; d < 6; d++) {
                        if (i % 2 == 0) {
                            nni = i + even_dr[d];
                            nnj = j + even_dc[d];
                        } else {
                            nni = i + odd_dr[d];
                            nnj = j + odd_dc[d];
                        }
                        if (nni < 0 || nnj < 0 || nnj > W - 1 || nni > H - 1) continue;
                        if (map[nni][nnj] > 0) continue;
                        zero++;
                    }
                    zero_len += 6 - zero;
                    zero = 0;
                }
            }
        }
        System.out.println(len - zero_len);
    } // end of main
    private static void BFS() {
        while (!q.isEmpty()) {
            int r, c;
            Point cur = q.poll();
            r = cur.r;
            c = cur.c;
            map[r][c] = 2;
            check[r][c] = true;
            int nr, nc;
            for (int d = 0; d < 6; d++) {
                if (r % 2 == 0) {
                    nr = r + even_dr[d];
                    nc = c + even_dc[d];
                } else {
                    nr = r + odd_dr[d];
                    nc = c + odd_dc[d];
                }
                if (nr < 0 || nc < 0 || nr > H - 1 || nc > W - 1) continue;
                if (map[nr][nc] == 1) continue;
                if (check[nr][nc]) continue;
                map[nr][nc] = 2;
                check[nr][nc] = true;
                q.offer(new Point(nr, nc));
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
