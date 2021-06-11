package BOJ;

import java.util.Scanner;

public class BJ_5585_거스름돈 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N =sc.nextInt();
        int change =1000-N;
        int chan[] ={500,100,50,10,5,1};
        int cnt =0;

        for (int i = 0; i < 6; i++) {
            if(chan[i]>change){
                continue;
            }else{
                int tmp = change/chan[i];
                change = change - tmp*chan[i];
                cnt += tmp;

            }
            if(change==0){
                System.out.println(cnt);
            }
        }
        
    } // end of main 
} // end of class 
