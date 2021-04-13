/*
 * 문제 접근법
 * 1. 다익스트라
 * 최단 시간 경로 => 그래프
 * 깊이 범위 0~9 (음수 x, 양의 가중치 -> 다익스트라)
 * 정점 .. "간선" 인접정점과의 연결
 * <벨만 포드>
 * -> 음의 가중치 허용*
 * 2. BFS
 * */
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1249_보급로_우선순위큐 {
    static int N, INF = Integer.MAX_VALUE;
    static int map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= TC; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = ch[j] - '0';
                }
            }
            System.out.println("#" + test_case + " " + dijkstra(0, 0));
        }


    } //end of main

    private static int dijkstra(int startR, int startC) {
        boolean[][] visited = new boolean[N][N];
        int[][] minTime = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minTime[i][j] = INF; // 엄청 큰수로 다 채워넣은거임
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        }); //정점 r[0],c[1] 출발지부터 복구시간[2]


        minTime[startR][startC] = 0;
        queue.offer(new int[]{startR, startC, minTime[startR][startC]});

        int r = 0, c = 0, cost = 0, nr, nc;
        int[] current;

        while (true) {
            cost = INF;
            // 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
            current = queue.poll();
            r = current[0];
            c = current[1];
            cost = current[2];

            if (visited[r][c]) continue;

            visited[r][c] = true;
            if (r == N - 1 && c == N - 1) return cost;

            // 선택된 정점기준으로 방문하지 않은 나머지 정점들 자신과의 경유시의 비용과 기존
            // 최소비용 비교하여 최소값 업데이트

            //현재 정점 위치 기준으로 4방의 인접정점을 ㅊ ㅓ리
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N
                        && !visited[nr][nc] && minTime[nr][nc] > cost + map[nr][nc]) {
                    minTime[nr][nc] = cost + map[nr][nc];
                    queue.offer(new int[]{nr, nc, minTime[nr][nc]});

                }
            }
        }
    }
} // end of class
