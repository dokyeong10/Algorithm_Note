package programmers;

import java.util.*;

public class 거리두기확인하기 { //거리 확인
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        boolean check[][] = new boolean[5][5];
        boolean flag = false;
        char[][] map = new char[5][5];
        for (int h = 0; h < 5; h++) {
            Queue<Point> q = new LinkedList<>();
            flag = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[j][k] = places[h][j].charAt(k);
                    if (map[j][k] == 'P') {
                        q.offer(new Point(j, k));
                    }
                }
            }
            while (!q.isEmpty()) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        check[j][k] = false;
                    }
                }
                Point cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                check[r][c] = true;
                int nr, nc;
                for (int d = 0; d < 4; d++) {
                    nr = r + dr[d];
                    nc = c + dc[d];
                    if (nr < 0 || nc < 0 || nr > 4 || nc > 4) continue;
                    if (map[nr][nc] == 'X') continue;
                    if (check[nr][nc]) continue;
                    if (map[nr][nc] == 'P') {
                        flag = true;
                        answer[h] = 0;
                        break;
                    }
                    check[nr][nc] = true;
                    int nrr, ncc;
                    for (int s = 0; s < 4; s++) {
                        nrr = nr + dr[s];
                        ncc = nc + dc[s];
                        if (nrr < 0 || ncc < 0 || nrr > 4 || ncc > 4) continue;
                        if (map[nrr][ncc] == 'X') continue;
                        if (check[nrr][ncc]) continue;
                        if (map[nrr][ncc] == 'P') {
                            flag = true;
                            answer[h] = 0;
                            break;
                        }
                        check[nrr][ncc] = true;
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
            if (!flag) {
                answer[h] = 1;
            }
        }
        return answer;
    }
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
