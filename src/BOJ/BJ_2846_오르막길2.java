package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2846_오르막길2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp;
        int answer = 0;
        int l = Integer.parseInt(st.nextToken()), r = l;
        for (int i = 1; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (r >= tmp) {
                answer = Math.max(answer, r - l);
                l = tmp;

            }
            r = tmp;
        }
        answer = Math.max(answer, r - l);
        System.out.println(answer);


    }


}
