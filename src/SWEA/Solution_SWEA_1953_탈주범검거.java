package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거 {
    static int N, M, R, C, L;
    static int map[][];
    static boolean visited[][];
    static int dr[] = {-1, 0, 0, 1}; // 상 0, 좌 1, 우 2 , 하 3
    static int dc[] = {0, -1, 1, 0};
    static String[] type = {
            null,
            "0312", //1 상하좌우
            "03",  //2 상하
            "12",  //3 좌우
            "02", //4 상우
            "32", //5: 하우
            "31", //6:하좌
            "01", //7:상좌

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); // 맵 행
            M = Integer.parseInt(st.nextToken()); // 맵 열
            R = Integer.parseInt(st.nextToken()); // 시작 위치 행
            C = Integer.parseInt(st.nextToken()); // 시작 위치 열
            L = Integer.parseInt(st.nextToken()); // 소요 시간

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 입력 받기 완료 //
            System.out.println("#" + test_case + " " + bfs());


        } // end of tc

    }// end of main

    private static int bfs() {
        int result = 0, time = 1;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{R, C});
        visited[R][C] = true;
        ++result;

        while (time++ < L) {
            int size = queue.size();
            while (size-- > 0) { // 동시간대 처리
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                String info = type[map[r][c]]; //현 구조물의 타입으로 이동 가능한 방향의 정보

                for (int d = 0, length = info.length(); d < length; d++) {
                    int dir = info.charAt(d) - '0';
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] > 0
                            && !visited[nr][nc] && type[map[nr][nc]].contains(Integer.toString(3-dir))) {
                        queue.offer(new int[]{nr,nc});
                        visited[nr][nc]=true;
                        ++result;


                    }

                }

            }


        }


        return result;
    }


}// end of class
