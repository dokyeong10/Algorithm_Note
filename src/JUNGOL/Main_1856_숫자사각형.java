package JUNGOL;

import java.util.Scanner;

public class Main_1856_숫자사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 1;
		int n = sc.nextInt(); // 행
		int m = sc.nextInt(); // 열
		int arr[][] = new int[n][m];

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j <= m-1; j++) {

					arr[i][j] = num++;
				}
			} else {
				for (int j = m-1; j >= 0; j--) {

					arr[i][j] = num++;
				}

			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <=m-1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
