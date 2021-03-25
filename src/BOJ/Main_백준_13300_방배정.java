package BOJ;

import java.util.Scanner;

public class Main_백준_13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 학생수
		int K = sc.nextInt(); // 한방 의 최대 인원
		int student[][] = new int[7][2];
		for (int i = 0; i < num; i++) {
			int S = sc.nextInt(); // 성별
			int Y = sc.nextInt(); // 학년
			student[Y][S]++;
		}
		int result = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				result += student[i][j] / K;
				result += student[i][j] % K == 0 ? 0 : 1;
			}
		}
		System.out.println(result);

	}// end of main
}// end of class
