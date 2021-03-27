package BOJ;

import java.util.Scanner;

public class Main_12871_무한문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder s = new StringBuilder(sc.nextLine());
        StringBuilder t = new StringBuilder(sc.nextLine());
        StringBuilder temp = new StringBuilder();
        if (s.length() < t.length()) {
            temp = new StringBuilder(t);
            t = new StringBuilder(s);
            s = new StringBuilder(temp);
        }

        while (s.length() > t.length()) {
             t.append(t);
        }
        if (s.toString().equals(t.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }//고

    } // end of main


} // end of class
