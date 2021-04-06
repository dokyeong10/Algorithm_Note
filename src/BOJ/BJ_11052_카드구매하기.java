package BOJ;

import java.util.Scanner;

public class BJ_11052_카드구매하기 {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int N =sc.nextInt(); // 카드 개수
        int card[]=new int[N+1];
        int d[]=new int[N+1];

        for (int i = 1; i <= N; i++) {
            card[i]=sc.nextInt();
        }/// 카드 가격 입력 받기 완료
        int max =0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=i ; j++) {
                d[i]=Math.max(d[i],d[i-j]+card[j]);
            }
        }
        // 일반화 d[i] = card[N]+d[i-N]

        System.out.println(d[N]);



    }// end of main
} // end of class
