package SWEA;

import java.util.Scanner;

public class Solution_5162_두가지빵의딜레마 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		for (int test_case = 1; test_case <=T; test_case++) {
			
			int A =sc.nextInt(); //현미빵
			int B =sc.nextInt(); //단호박빵
			int C =sc.nextInt(); // 가진 돈
			
			int result = Math.min(A,B);
			
			System.out.println("#"+test_case+" "+(C/result));
			
		}// end of tc
	}// end of main
}// end of class
