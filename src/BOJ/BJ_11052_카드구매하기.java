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


        for (int i = 1; i <= N; i++) { // card type
            for (int j = 1; j <=i ; j++) {
                d[i]=Math.max(d[i],d[i-j]+card[j]);
                //d[1] + card[1]
                //d[0] + card[2]

                //d[2] + card[1]
                //d[1] + card[2]
                //d[0] + card[3]

                //d[3] + card[1]
                //d[2] + card[2]
                //d[1] + card[3]
                //d[0] + card[4]
            }
        }
        // 일반화 d[i] = card[N]+d[i-N]

        System.out.println(d[N]);



    }// end of main
} // end of class
