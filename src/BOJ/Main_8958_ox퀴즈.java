package BOJ;

import java.util.Scanner;

public class Main_8958_ox퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 0; test_case < T; test_case++) {
			String s = sc.nextLine();
			int result=0;
			int sum=0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='O') {
					result++;
					sum+=result;
				}else {
					result=0;
				}
			}
			System.out.println(sum);
		}
	
	}

}
