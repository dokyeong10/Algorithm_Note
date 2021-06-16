package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int distance[] = new int[N - 1];
        int gas[] = new int[N];
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        } // 입력 받기 완료
        long result = (long) distance[0] * gas[0];
        for (int i = 1; i < N - 1; i++) {
            if (i == 1) {
                if (gas[i] < gas[0]) {
                    result += (long) gas[i] * distance[i];
                    min = gas[i];

                } else {
                    result += (long) gas[0] * distance[i];
                    min = gas[0];
                }
            } else {
                if (gas[i] < min) {
                    result += (long) gas[i] * distance[i];
                    min = gas[i];
                } else {
                    result += (long) min * distance[i];
                }
            }
        }
        System.out.println(result);


    } // end of main
} // end of class
