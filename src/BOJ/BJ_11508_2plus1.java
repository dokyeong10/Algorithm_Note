package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11508_2plus1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int milk[] = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            milk[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(milk);
        int re[] = new int[N + 1];
        int n = N;
        for (int i = 0; i < N; i++) {
            re[n] = milk[i];
            n--;
        }
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i > 1 && i % 3 == 0) {
                continue;
            } else {
                result += re[i];
            }
        }
        System.out.println(result);

    }// end of main
} // end of class
