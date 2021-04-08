package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15651_N과M3 {

    static int N,R;
    static int[]numbers;

    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);


        N =sc.nextInt();
        R=sc.nextInt();
        numbers=new int[R];
        isSelected =new boolean[R];
        dupurmutation(0);
        System.out.println(sb);

    } // end of main

    private static void dupurmutation(int cnt) {

        if(cnt==R){
            for (int i = 0; i < R; i++) {
                sb.append(numbers[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <=N ; i++) {
            numbers[cnt]=i;
            dupurmutation(cnt+1);
        }

    }
}// end of class
