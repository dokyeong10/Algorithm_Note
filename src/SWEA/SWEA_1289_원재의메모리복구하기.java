package SWEA;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int TC =sc.nextInt();
        for (int test_case = 1; test_case <=TC; test_case++) {
            String s =sc.next();
            int []bit =new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                bit[i]=s.charAt(i)-'0';
            } // 입력 후 쪼개기 완료 //

            for (int i = 0; i < s.length(); i++) {
                //if()
            }
int result =0;



        sb.append("#").append(test_case).append(" ").append("");
        } //end of tc
        System.out.println(sb);


    } //end of main
} // end of class
