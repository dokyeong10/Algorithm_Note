package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * DFS와 BFS로 출력하시오
 *
 * */
public class BJ_1260_DFS와BFS {
    static int N, M, V;
    static boolean arr[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt(); //정점 개수
        M = sc.nextInt(); // 간선 개수
        V = sc.nextInt(); // 시작 번호
        arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr[from][to] = arr[to][from] = true;
        }

        visited = new boolean[N + 1];

        dfs(V);
        sb.append('\n');
        Arrays.fill(visited, false);

        bfs(V);
        System.out.print(sb);

    }// end of main

    private static void dfs(int current) {
        visited[current]=true;
        sb.append(current).append(' ');

        for (int i = 1; i <=N ; i++) {
            if(arr[current][i]&&!visited[i]){
                dfs(i);
            }
        }

    } // end of current

    private static void bfs(int current) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(current);
        visited[current] = true;

        while (!q.isEmpty()) {
            current = q.poll();
            sb.append(current).append(' ');
            for (int i = 1; i <= N; i++) {
                if (arr[current][i] && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    } // end of bfs


} // end of class
