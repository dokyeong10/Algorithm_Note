package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2217_로프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int rope[] = new int[N];
        int a = N;
        int max = 0, result = 0;
        for (int i = 0; i < N; i++) {
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope);
        for (int i = 0; i < N; i++) {
            result = rope[i] * a;
            max = Math.max(result, max);
            a--;
        }
        System.out.println(max);
    } // end of main
} // end of class
