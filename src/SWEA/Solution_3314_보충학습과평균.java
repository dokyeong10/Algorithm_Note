package SWEA;

import java.util.Scanner;

public class Solution_3314_보충학습과평균 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T =sc.nextInt();
		
		for (int test_case = 1; test_case <=T; test_case++) {
			int score[]= new int[5];
			int sum=0;
			for (int i = 0; i < 5; i++) {
				score[i]=sc.nextInt();
				if(score[i]<40) {
					score[i]=40;
				}
				sum+=score[i];
			}
			System.out.println("#"+test_case+" "+(sum/5));
		}// end of tc
	}// end of main
}// end of class
