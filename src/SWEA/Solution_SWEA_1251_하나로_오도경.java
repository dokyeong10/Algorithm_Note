package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1251_하나로_오도경 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());


            long[][] adjMatrix = new long[N][N];
            boolean[] visited = new boolean[N];
            long[] minEdge = new long[N];

            StringTokenizer stx = new StringTokenizer(br.readLine(), " ");
            StringTokenizer sty = new StringTokenizer(br.readLine(), " ");

            int[][] list = new int[N][2];

            for (int i = 0; i < N; i++) {
                list[i][0] = Integer.parseInt(stx.nextToken());
                list[i][1] = Integer.parseInt(sty.nextToken());

            } /// 입력 받기 완료 ///

            double E = Double.parseDouble(br.readLine());

            for (int i = 0; i < N; i++) {
                long dx, dy, dist;
                for (int j = 0; j < N; j++) {
                    dx = Math.abs(list[i][0] - list[j][0]);
                    dy = Math.abs(list[i][1] - list[j][1]);
                    dist = (long) (Math.pow(dx, 2) + Math.pow(dy, 2));
                    adjMatrix[i][j] = dist;
                }
                minEdge[i] = Long.MAX_VALUE;
            }

            long result = 0;
            minEdge[0] = 0;
            for (int c = 0; c < N; c++) {
                long min = Long.MAX_VALUE;
                int minVertex = 0;
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && min > minEdge[i]) {
                        min = minEdge[i];
                        minVertex = i;
                    }
                }

                result += min;
                visited[minVertex] = true;

                for (int i = 0; i < N; i++) {
                    if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
                        minEdge[i] = adjMatrix[minVertex][i];
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append((long)(Math.round(result*E))).append('\n');

        } // end of tc
        System.out.println(sb);


    }// end of main
}// end of class
