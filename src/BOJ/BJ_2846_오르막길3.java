package BOJ;

import java.util.Scanner;

public class BJ_2846_오르막길3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int road[] = new int[N];

        int tmp = 0, ansewr = 0;
        int r = 0;
        int l = sc.nextInt();
        r = l;

        for (int i = 1; i < N; i++) {
            tmp = sc.nextInt();
            if (r >= tmp) {
                ansewr = Math.max(ansewr, r - l);
                l = tmp;
            }
            r = tmp;
        }
        ansewr = Math.max(ansewr, r - l);
        System.out.println(ansewr);


    } // end of main
} // end of class
