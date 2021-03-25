package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_9205_맥주마시면서걸어가기_오도경 {
    static int N;
    static int[] StoreX;
    static int[] StoreY;
    static boolean[] visited;
    static boolean flag;

    static int homeX, homeY;

    static int festiX, festiY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            StoreX = new int[N];
            StoreY = new int[N];
            visited = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                StoreX[i] = Integer.parseInt(st.nextToken());
                StoreY[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            festiX = Integer.parseInt(st.nextToken());
            festiY = Integer.parseInt(st.nextToken());

            //입력받기 완료
            flag = false;
            DFS(homeX, homeY);
            sb.append(flag?"happy":"sad").append('\n');


        } //end of tc

        System.out.println(sb);
    } // end of main


    private static void DFS(int x, int y) {

        if (Math.abs(x - festiX) + Math.abs(y - festiY) <= 1000) {
            flag = true;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (Math.abs(x - StoreX[i]) + Math.abs(y - StoreY[i]) <= 1000 && !visited[i]) {
                visited[i] = true;
                DFS(StoreX[i], StoreY[i]);
            }
        }
        return;
    }
} //end of class
