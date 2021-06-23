package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1325_효율적인해킹 {
    static int N, M, max, cnt;
    static ArrayList<Integer>[] computer;
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
        M = Integer.parseInt(st.nextToken());  // 신뢰관계 수
        computer = new ArrayList[N + 1];
        max = 0;
        check = new boolean[N + 1];
        int result[] = new int[N + 1];
        for (int i = 0; i <=N ; i++) {
            computer[i] =new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            computer[B].add(A);
        }
        for (int i = 1; i <= N; i++) {
            cnt = 0;
            DFS(i);
            for (int j = 1; j <= N; j++) {
                if (check[j]) {
                    cnt++;
                    check[j] = false;
                }
            }
            result[i] = cnt;
            max = Math.max(max, cnt);
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);


    } // end of main

    private static void DFS(int i) {
        check[i] = true;
        for (int j = 0; j < computer[i].size(); j++) {
            if (!check[computer[i].get(j)]) {
                DFS(computer[i].get(j));
            }
        }


    }
} // end of class
