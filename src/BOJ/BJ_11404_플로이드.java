package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        int map[][] = new int[N][N];

        int Max = 1000000000;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = Max;
            }
        }// 맥스로 채워놈
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int arrive = Integer.parseInt(st.nextToken()) - 1;
            int price = Integer.parseInt(st.nextToken());

            map[start][arrive] = Math.min(map[start][arrive], price);
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][i] = 0;
                if(map[i][j]==Max) map[i][j]=0;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }// end of main
} // end of class
