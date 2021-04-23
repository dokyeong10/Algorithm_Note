package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기_민규샘 {
    static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 상우 우 우하 하 하좌 좌 상좌
    static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
    private static boolean[][] visited;
    private static int[][] cnt;
    private static char[][] m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
            m = new char[N + 2][N + 2]; //외곽을 한줄씩 빈공간 여분으로 둠, 사용하지 않음
            cnt = new int[N + 2][N + 2]; // 내주변 8방에 있는 폭탄의 개수
            for (int i = 1; i <= N; i++) {
                String s = br.readLine();
                for (int j = 1; j <= N; j++) {
                    m[i][j] = s.charAt(j - 1);
                    if (m[i][j] == '*') { // 폭탄이라면
                        cnt[i][j] = '*'; //폭탄이라고 표시
                        for (int k = 0; k < dr.length; k++) { //주변 팔방에 1씩 증가 시키기 
                            if (m[i + dr[k]][j + dc[k]] != '*') { /// 폭탄이 아닌곳만 카운팅
                                cnt[i + dr[k]][j + dc[k]]++;
                            }
                        }
                    }
                }
            }
            visited = new boolean[N + 2][N + 2]; //방문 여부
            for (int i = 0; i < visited.length; i++) {
                visited[0][i] = true;
                visited[N + 1][i] = true;
                visited[i][0] = true;
                visited[i][N + 1] = true;
            }

            int result = 0; //몇번 클릭이 필요한지 카운팅
            //cnt 배열에 0인 부분을 찾아서 bfs로 탐색
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visited[i][j] && cnt[i][j] == 0) { // 미방문, 0인지점부터 시작
                        bfs(i, j); //주변 0은 모두 방문하고, 0 아닌것은 한꺼풀만 더 방문
                        result++;
                    }
                }
            }

            // 방문하지 않은 0이 아닌 폭탄이 아닌 칸을 카운팅
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visited[i][j] && m[i][j] != '*') { //폭탄이 아니면 카운팅
                        result++;
                        visited[i][j] = true;
                    }
                }
            }
            sb.append('#').append(test_case).append(' ').append(result).append('\n');


        } //  end of tc
    } // end of main

    /* 주변 0은 모두 방문하고 0아닌것은 한꺼풀만 더 방문 */
    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<int[]>();

        visited[r][c] = true;
        q.offer(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            r = temp[0];
            c = temp[1];
            for (int i = 0; i < dr.length; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (visited[nr][nc]) continue; // 방문했으면 그만
                // 0이 아니면 방문체크만 하기
                // 0이면 방문체크하고 큐에 넣기
                visited[nr][nc] = true;
                if (cnt[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

} // end of class

