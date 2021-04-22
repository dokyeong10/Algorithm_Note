package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_20400_서강근육맨 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long sports[] = new long[N];

        for (int i = 0; i < N; i++) {
            sports[i] = sc.nextLong();
        }
        Arrays.sort(sports);

        long result = 0, sum = 0;
        int k = 0;
        if (N % 2 == 0) {
            k = N - 1;
            for (int i = 0; i < N / 2; i++) {
                sum = (sports[i] + sports[k]);
                k--;
                result = Math.max(result, sum);
            }
        } else {
            k = N - 2;
            for (int i = 0; i < (N - 1) / 2; i++) {
                sum = sports[i] + sports[k];
                k--;
                result = Math.max(result, sum);
            }
            result = Math.max(result, sports[N - 1]);
        }

        System.out.println(result);
    } // end of main
} // end of class
