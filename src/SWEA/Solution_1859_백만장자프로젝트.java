package SWEA;

import java.util.Scanner;

public class Solution_1859_백만장자프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 연속된 일수
			int val[] = new int[N]; // 가격 부여
			int cnt = 0; // 횟수
			int sum = 0; // 합
			int realmon = 0;
			for (int i = 0; i < N; i++) {
				val[i] = sc.nextInt();
			} //// 입력받기////
//			int max = 0;

//			for (int i = 0; i < N; i++) {
//				max = Math.max(max, val[i]);
//			}

			for (int i = 0; i < N - 1; i++) {
				 if (val[i] <= val[i + 1]) {
					sum += val[i];
					cnt++;
					if (val[i + 1] == val[N - 1]) {
						realmon += val[i + 1] * cnt - sum;
						break;
					}
				}
				else if (val[i] > val[i + 1]) {
					realmon += val[i] * cnt - sum;
					cnt = 0;
					sum = 0;
				}
			}
			System.out.println("#" + test_case + " " + realmon);
		} // end of tc
	}// end of main
}// end of class