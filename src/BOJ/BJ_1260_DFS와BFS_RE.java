package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS_RE {
    static int N, M, V;
    static boolean arr[][], visited[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = arr[to][from] = true;

        }
        visited =new boolean[N+1];

        DFS(V);
        sb.append('\n');
        Arrays.fill(visited,false);
        BFS(V);
        System.out.println(sb);


    } // end of main .

    private static void BFS(int current) {
        Queue<Integer>q = new LinkedList<>();
        q.offer(current);
        visited[current]=true;
        while(!q.isEmpty()){
            current =q.poll();

            sb.append(current).append(' ');
            for (int i = 1; i <=N ; i++) {
                if(arr[current][i]&&!visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }


        }




    }

    private static void DFS(int current) {
        visited[current] =true;
        sb.append(current).append(' ');
        for (int i = 1; i <=N ; i++) {
            if(arr[current][i]&&!visited[i]){

               DFS(i);

            }
        }

    }
} // end of class
