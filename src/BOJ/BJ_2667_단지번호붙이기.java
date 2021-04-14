package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2667_단지번호붙이기 {
    static int N, totalnum, num;
    static int apt[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean visited[][];
    static ArrayList<Integer> result = new ArrayList<Integer>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        apt = new int[N][N]; // 배열
        visited = new boolean[N][N]; // 중복 체크
        totalnum = 0; // 단지 개수

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                apt[i][j] = s.charAt(j) - '0';
            }
        } // 입력 받기 완료 //

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apt[i][j] == 1 && !visited[i][j]) { //값이 1이고 방문한적없으면 비엪에스로
                    bfs(i, j);
                }
            }
        }
        System.out.println(totalnum); // 단지 수
        Collections.sort(result); // 각 단지 수 정렬
        for (int num1 : result) {
            System.out.println(num1);
        }


    } //end of main

    private static void bfs(int r, int c) {
        num = 0; // 단지 수 초기화
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        totalnum++;
        num++;
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int nr, nc;

            for (int d = 0; d < 4; d++) {
                nr = cur.r + dr[d];
                nc = cur.c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (apt[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                num++;
                q.offer(new Point(nr, nc));
            }
        }
        result.add(num); // 리스트에 값 넣어줌
    } // end of bfs

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}// end of class
