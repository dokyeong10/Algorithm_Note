package BOJ;

import java.util.Scanner;

public class BJ_14916_거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = N;
        int cnt = 0;
        if (a % 5 == 0) {
            cnt = a / 5;
            System.out.println(cnt);
            return;
        } else if (a / 5 != 0) {
            for (int i = N / 5; i > 0; i--) {
                a = N - i * 5;
                if (a % 2 == 0) {
                    cnt = i + a / 2;
                    System.out.println(cnt);
                    return;
                } else {
                    continue;
                }
            }
        }
        if (cnt == 0) {

            if (N % 2 == 0) {
                cnt = N / 2;
                System.out.println(cnt);
            } else {
                System.out.println(-1);
            }
        }

    } // end of main
} // end of class
