package SWEA;

import java.util.Scanner;

public class Solution_SWEA_8382_방향전환 {


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int TC =sc.nextInt();
        for (int test_case = 1; test_case <=TC ; test_case++) {
            int x1 =sc.nextInt();
            int y1 =sc.nextInt();
            int x2 =sc.nextInt();
            int y2 =sc.nextInt();
            int x =Math.abs(x1-x2);
            int y =Math.abs(y1-y2);
           int result=0;
            if(x==y){
             result =x+y;

            }else {

            }
            System.out.println("#"+test_case+" "+result);

        }// end of tc


    } // end of main
} // end of class
