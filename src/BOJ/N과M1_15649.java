package BJ;

import java.util.Scanner;

public class N과M1_15649 {

    static int[]numbers;
    static int N,M ;
    static boolean[] isSelected;


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        
         N=sc.nextInt(); //4
         M=sc.nextInt(); //2
        isSelected=new boolean[N+1];
        numbers =new int[N];

        permutation(0);
        
    }

    private static void permutation(int d) {
        if(d==M){
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i]+" ");
            }
            System.out.println();
            return ;
        } //오황성현 찐다


        for (int i = 1; i <=N; i++) {
            if(isSelected[i]==false){
                isSelected[i]=true; // 1 2 3 4 // 1 2
                numbers[d]=i;
                permutation(d+1);
                isSelected[i]=false;
            }
        }

    }
} //end of class
