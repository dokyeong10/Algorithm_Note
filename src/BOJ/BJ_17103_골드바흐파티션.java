package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_17103_골드바흐파티션 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        ArrayList<Integer> prime = new ArrayList<>();

        boolean[] check = new boolean[1000001];

        // 소수 구하기.
        check[0] = check[1] = true; // 0과 1은 true 로 시작

        for (int i = 2; i < 1000001; i++) {
            if (check[i] == false) {
                prime.add(i);
                for (int j = i + i; j < 1000001; j += i)
                    check[j] = true;
            }
        }

        // N/2까지만 탐색하는 방법.
        while (T-- > 0) {
            int N = sc.nextInt();
            int result = 0;
            for (int i = 0; prime.get(i) <= N / 2; i++) {
                // 골드바흐가 맞다면
                if (check[N - prime.get(i)] == false) {
                    result++;
                }
            }
            System.out.println(result);
        }

    }// end of main
} // end of class
