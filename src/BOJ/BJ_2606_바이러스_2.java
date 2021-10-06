package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_2606_바이러스_2 {//바이러스 2
    private static boolean[] check;
    private static ArrayList<Integer>[] com;
    static int N, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터 개수(노드)
        l = Integer.parseInt(br.readLine()); // 간선 수
        int virus[][] = new int[100][100];
        check = new boolean[N + 1];
        com = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            com[i] = new ArrayList<>();
        }
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int fir = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            com[fir].add(end);
            com[end].add(fir);
        }
        DFS(1);
        int result = 0;
        for (int i = 0; i < N + 1; i++) {
            if (check[i] == true)
                result++;
        }
        System.out.println(result - 1);
    } // end of main
    private static void DFS(int i) {
        check[i] = true;
        for (int V : com[i]) {
            if (check[V] == false)
                DFS(V);
        }
    }
} // end of class
