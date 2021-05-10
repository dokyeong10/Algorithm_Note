package BOJ;

import java.util.Scanner;

public class BJ_9742_순열 {
    private static String s;
    static int N;
    static char sen[];
    static boolean check;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
         s =sc.next();
         N =sc.nextInt();
         sen=new char[s.length()];
         check=false;

        for (int i = 0; i < s.length(); i++) {
            sen[i]=s.charAt(i);
        }
        puermu(s.length(),N);

    } // end of main

    private static void puermu(int l,int m) {
        int cnt=0;
        if(cnt==N){
            return;
        }

        for (int i = 0; i < s.length(); i++) {

        }

    }
} // end of class
