package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15652_N과M4 {
    static int N,R;
    static int []numbers;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        R=sc.nextInt();

        numbers=new int[R];

        ducomb(0,1);
        System.out.println(sb);

    }

    private static void ducomb(int cnt, int start) {

        if(cnt==R){
            for (int i = 0; i <R ; i++) {
                sb.append(numbers[i]+" ");
            }
            sb.append('\n');
            //System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i <=N ; i++) {
            numbers[cnt]=i;
            ducomb(cnt+1,i);
        }


    }


}
