package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2675_문자열반복 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			int R = sc.nextInt(); // 반복할 횟수
			String s = sc.next(); // 반복할 문자열
			char result[] = new char[s.length()*R];
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < R; j++) {
					result[i]=s.charAt(i);
					System.out.print(result[i]);
				}
				
			}
			System.out.println();

		}
	}

}
