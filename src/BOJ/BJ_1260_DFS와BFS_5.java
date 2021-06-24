package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1260_DFS와BFS_5 {
    static int N, M, V;
    static ArrayList<Integer> arr[];
    static Queue<Point> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int fir = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[fir].add(end);
            arr[end].add(fir);
        } // 노드간 연결 완료
        for (int i = 0; i < N; i++) {
            Collections.sort(arr[i]);
        }

        sb.append(V).append(" ");
        DFS(V);
        for (int i = 0; i < N + 1; i++) {
            check[i] = false;
        }
        sb.append('\n').append(V).append(" ");
        BFS(V);
        System.out.println(sb);


    } // end of main

    private static void BFS(int v) {
        q.offer(new Point(v));
        check[v] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int r = cur.r;
            int nr = 0;
            for (int i = 0; i < arr[r].size(); i++) {
                if (check[arr[r].get(i)]) continue;
                nr = arr[r].get(i);
                check[arr[r].get(i)] = true;
                sb.append(nr).append(" ");
                q.offer(new Point(nr));
            }
        }
    }

    private static void DFS(int v) {
        check[v] = true;
        for (int i = 0; i < arr[v].size(); i++) {
            if (!check[arr[v].get(i)]) {
                check[arr[v].get(i)] = true;
                sb.append(arr[v].get(i)).append(" ");
                DFS(arr[v].get(i));

            }
        }
    }

    static class Point {
        int r;

        public Point(int r) {
            this.r = r;
        }
    }

} // end of class
