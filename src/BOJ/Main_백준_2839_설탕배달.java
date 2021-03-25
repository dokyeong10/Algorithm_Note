package BOJ;

import java.util.Scanner;

public class Main_백준_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 킬로그램
		int result = 0;

		if (N % 5 == 0) {
			System.out.println(N / 5);
			return;
		} else {
			result = N / 5;
			for (int i = result; i > 0; i--) {
				int temp = N - (i * 5);
				if (temp % 3 == 0) {
					System.out.println(i + (temp / 3));
					return;
				}
			}
		}
		if (N % 3 == 0) {
			System.out.println(N / 3);
		} else {
			System.out.println(-1);
		}
		return;

	}
}
