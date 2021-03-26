package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1263_사람네트워크2 {

    static int tc;
    static int[][] map;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(bf.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 0) map[i][j] = INF;
                }
            }

            for (int k = 0; k < N; ++k) {
                for (int i = 0; i < N; ++i) {
                    if (i == k) continue;
                    for (int j = 0; j < N; ++j) {
                        if (i == j || k == j) continue;
                        if (map[i][k] != INF && map[k][j] != INF && map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            int minCC = INF;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    sum += map[i][j];
                }
                minCC = Math.min(minCC, sum);
            }
            sb.append('#').append(t).append(' ').append(minCC).append('\n');
        }
        System.out.println(sb);
    }
} // end of class
