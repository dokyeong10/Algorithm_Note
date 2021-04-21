package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_TEST {
    static int n, m;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int[] rotateNum = {4, 2, 4, 4, 1};
    static int[][] arrow = {{1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3}};

    static int[][] map = new int[11][11];
    static ArrayList<int[]> cctv = new ArrayList<>();

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int areaNum = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] <= 5) cctv.add(new int[]{i, j});
                else if (map[i][j] == 0) areaNum++;
            }
        }
        answer = areaNum;
        dfs(0, areaNum);
        System.out.println(answer);
    }

    static void dfs(int depth, int areaNum) {
        if (depth == cctv.size()) {
            answer = Math.min(answer, areaNum);
            return;
        }
        int temp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][j];
            }
        }

        int type = map[cctv.get(depth)[0]][cctv.get(depth)[1]] - 1;
        for (int i = 0; i < rotateNum[type]; i++) {
            int cnt = 0;
            for (int j = 0; j < arrow[type].length; j++) {
                cnt += draw(depth, (arrow[type][j] + i) % 4);
            }
            for(int r=0;r<n;r++){
                for(int c=0;c<m;c++){
                    System.out.print(map[r][c]+" ");
                }
                System.out.println();
            }
            System.out.println();
            

            dfs(depth + 1, areaNum - cnt);
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    map[r][c] = temp[r][c];
                }
            }
        }
    }

    static int draw(int depth, int dir) {
        int[] cur = new int[2];
        cur[0] = cctv.get(depth)[0];
        cur[1] = cctv.get(depth)[1];
        cur[0] += dy[dir];
        cur[1] += dx[dir];
        int cnt = 0; // 넓힌 시야의 개수
        while ((cur[0] >= 0 && cur[0] < n && cur[1] >= 0 && cur[1] < m)
                && (map[cur[0]][cur[1]] != 6)) {
            if (map[cur[0]][cur[1]] == 0) {
                cnt++;
                map[cur[0]][cur[1]] = 9;
            }
            cur[0] += dy[dir];
            cur[1] += dx[dir];
        }
        return cnt;
    }

}