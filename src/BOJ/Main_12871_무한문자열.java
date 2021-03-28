package BOJ;

import java.util.Scanner;

public class Main_12871_무한문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        if (s.length() > t.length()) {
            String temp = t;
            t = s;
            s = temp;
        } //무조건 t 문자열이 길게

        //최소공배수 형식

        int cnt = s.length() * t.length();
        String T = t;
        String S = s;
        if (s.length() != cnt) {
            for (int i = 0; i < (cnt / t.length() - 1); i++) {
                T += t;
            }
            for (int i = 0; i < (cnt / s.length() - 1); i++) {
                S += s;
            }
        }
        if (S.equals(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    } // end of main
} // end of class
