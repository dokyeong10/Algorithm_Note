package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N =sc.nextInt(); //사람수
        int line[]=new int[N];
        for (int i = 0; i < N; i++) {
            line[i]=sc.nextInt();
        } // 입력 받기 완료 //

        Arrays.sort(line); // 오름차순 정렬
        int sum=0;
        for (int i = 0; i < N; i++) {
            sum+=line[i]*(N-i);
        }
        System.out.println(sum);

    }// end of main
}// end of class
