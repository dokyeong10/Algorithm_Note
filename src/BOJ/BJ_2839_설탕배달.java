package BOJ;

import java.util.Scanner;

public class BJ_2839_설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int to = 0;
        to = N / 5;
        while (to > -1) {
            if ((N - (to * 5)) % 3 == 0) {
                cnt += to;
                N -= to * 5;
                cnt += N / 3;
                System.out.println(cnt);
                return;
            } else {
                to--;
                continue;
            }
        }
        System.out.println(-1);
    } // end of main
} // end of class
