package 도경작성;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위던지기1 {
    static int N, totalCnt;
    static int[] numbers;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //주사위 던진 횟수
        numbers = new int[N];
        isSelected = new boolean[7]; // 1~6번 주사위 넣기

        int M = sc.nextInt();
        totalCnt = 0;
        switch (M) {
            case 1:
                duplpermutation(0);
                break;
            case 2:
                permutation(0);
                break;
            case 3:
                duplcomb(0, 1);
                break;
            case 4:
                comb(0, 1);
                break;
        }
        System.out.println(totalCnt);

    }// end of main

    private static void comb(int cnt, int start) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static void duplcomb(int cnt, int start) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i;
            duplcomb(cnt + 1, i);
        }

    }

    private static void duplpermutation(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1; i <= 6; i++) {
            numbers[cnt] = i;
            duplpermutation(cnt + 1);
        }
    }

    private static void permutation(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if (isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }

    }


} // end of class
