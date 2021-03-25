package JUNGOL;

import java.util.Scanner;

public class Main_jungol_1998_오류교정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		} /// 입력받기///
		int total = 0;
		int sum[] = new int[N + 1]; // 행합
		int sum2[] = new int[N + 1];// 열합
		int cnt1 = 0;// 합 홀수 개수 행
		int cnt2 = 0;// 합 홀수 개수 열

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum[i] += map[i][j];
				sum2[i] += map[j][i];
				total +=map[i][j];
			}
		} // 각 행과 열의 합 저장 //
		for (int i = 1; i <= N; i++) {
			if (sum[i] % 2 == 1) {
				cnt1++;
			} else if (sum2[i] % 2 == 1) {
				cnt2++;
			}
		} // 개수 카운트

		if (total==1||cnt1 == cnt2 && cnt1 != 0) {
			for (int i = 1; i <= N; i++) {
				if (sum[i] % 2 == 1) {
					for (int j = 1; j <= N; j++) {
						if (sum2[j] % 2 == 1) {
							System.out.println("Change bit (" + i + "," + j + ")");
							return;
						}
					}
				}
			}
		} else if (cnt1 != cnt2) {
			System.out.println("Corrupt");
		} else if (cnt1 == 0 && cnt2 == 0) {
			System.out.println("OK");

		}
	}
}
