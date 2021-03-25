package BOJ;

import java.util.Scanner;

public class Main_백준_2563_색종이_오도경 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 수
		int cnt = 0;

		int black[][] = new int[100][100]; // 검은색
		boolean check[][] = new boolean[100][100];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < 10; j2++) {
					int nr = x + j;
					int nc = y + j2;
					if (nr < 100 && nr >= 0 && nc < 100 && nc >= 0 && check[nr][nc] == false) {
						black[nr][nc] = 1;
						check[nr][nc] = true;
						cnt++;
					}

				}
			}
		}

		System.out.println(cnt);

	}// end of main
} // end of class