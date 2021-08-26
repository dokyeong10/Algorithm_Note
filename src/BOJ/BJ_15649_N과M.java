package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15649_N과M {
    static int N, M;
    static boolean check[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N + 1];
        arr = new int[N];
        permutation(0);
    } // end of main

    private static void permutation(int num) {
        if (num == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                if (!check[i]) {
                    check[i] = true;
                    arr[num] = i;
                    permutation(num + 1);
                    check[i] = false;
                }
            }
        }
    }
}// end of class
