package BJ;

import java.util.Scanner;

public class Main_백준_1463_1로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] C = new int[N + 1];
        C[0] = 0;
        C[1]=0;
        C[2]=1;
        C[3]=1;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            if (C[i - 1] - 1 < min) min = C[i - 1] - 1;
            if (i >= 2 && C[i / 2] + 1 < min) min = C[i / 2];
            if (i >= 3 && C[i / 3] + 1 < min) min = C[i / 3];
            C[i] = min;
            cnt++;
            if (C[i] == 1) break;
        }
        System.out.println(cnt);

    }// end of main
} // end of class
