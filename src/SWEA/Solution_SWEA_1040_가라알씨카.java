package SWEA;

import java.util.Scanner;

public class Solution_SWEA_1040_가라알씨카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int sum = 0;
			int v = 0;
			for (int i = 0; i < N; i++) {
				int c = sc.nextInt();
				switch (c) {
				case 0:
					break;
				case 1:
					v += sc.nextInt();

					break;
				case 2:
					v -= sc.nextInt();
					break;
				}
				if (v < 0)
					v = 0;
				sum += v;
			}
			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}
}
