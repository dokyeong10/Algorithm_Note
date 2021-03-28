package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_17103_골드바흐파티션 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int T =sc.nextInt();
        for (int test_case = 1; test_case <=T ; test_case++) {

            int N =sc.nextInt();
            boolean check[]=new boolean[N+1];
            int value[]=new int[N+1];
            check[1]=true;


            for (int i = 2; i <=Math.sqrt(N) ; i++) {
                for (int j = 2; i*j <=N ; j++) {
                    check[j*i]=true;
                }
            }
            for (int i = 2; i <=N ; i++) {
                if(!check[i]){
                    for (int j = 0; j <N; j++) {
                        value[j]=i;
                    }
                }
            } // N보다 작은 소수들만 저장

            System.out.println(Arrays.toString(value));

        } // end of tc
    }// end of main
} // end of class
