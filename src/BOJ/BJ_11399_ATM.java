package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11399_ATM { //ATM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int atm[] = new int[N];
        int result = 0;
        int cnt = N;
        for (int i = 0; i < N; i++) {
            atm[i] = sc.nextInt();
        }
        Arrays.sort(atm);
        for (int i = 0; i < N; i++) {
            result += atm[i] * cnt;
            cnt--;
        }
        System.out.println(result);
    } // end of main
} // end of class
