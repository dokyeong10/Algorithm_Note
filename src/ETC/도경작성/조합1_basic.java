package 도경작성;

import java.util.Arrays;
import java.util.Scanner;

public class 조합1_basic {
    static int N, R;
    static int numbers[];
    static int input[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        numbers = new int[R];
        combination(0, 1);


    } // end of main

    private static void combination(int cnt, int start) {
        if (cnt == R) {
            for (int i = 0; i < cnt; i++) {
                System.out.print(numbers[i]+" ");
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }


    }
} // end of class
