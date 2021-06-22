package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20115_에너지드링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int energy[] = new int[N];
        double max = 0.0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, energy[i]);
        }
        double result = max;
        for (int i = 0; i < N; i++) {
            if (energy[i] != max) {
                result = (double) energy[i] / 2 + result;
            } else {
                continue;
            }
        }
        System.out.println(result);
    } // end of main
} // end of class
