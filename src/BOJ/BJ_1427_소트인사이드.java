package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1427_소트인사이드 { //소트인사이드
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        // 문자열 쪼개기
        Arrays.sort(arr);
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }

    }// end of main
}// end of class
