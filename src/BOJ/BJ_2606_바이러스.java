package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* DFS로 연결
* true로 표시 된 것들 -1 ( 1은 빼야함 )
* */
public class BJ_2606_바이러스 {
    static int com, M, cnt;
    static boolean visited[], arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new boolean[com + 1][com + 1];
        visited = new boolean[com + 1];
        int cnt = 0;
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = arr[to][from] = true;
        }
        dfs(1);
        for (int i = 1; i <= com; i++) {
            if (visited[i]) {
                cnt++;
            }
        }
        System.out.println(cnt - 1);
    }

    private static void dfs(int current) {
        visited[current] = true;
        for (int i = 1; i <= com; i++) {
            if (arr[current][i] && !visited[i]) {
                dfs(i);
            }
        }

    }
}// end of class
