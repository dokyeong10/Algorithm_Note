package SWEA;

import java.util.Scanner;

public class Solution_SWEA_2805_농작물수확하기ㄱ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= 50; test_case++) {
			int N = sc.nextInt();
			int farm[][] = new int[N][N];
			int sum = 0;

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					if (i + j >= N / 2 && i - j <= N / 2&&i-j>=-N/2&&i+j<=N/2*3) {
						int num = s.charAt(j) - '0';
						farm[i][j] = num;
						sum += num;
					}
				}
			}

			System.out.println("#" + test_case + " " + sum);

		} // end of tc

	} // end of main
} // end of class
