package BOJ;

import java.util.Scanner;

public class Main_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 장수
		boolean check = true;
		int map[][] = new int[101][101];
		int sum = 0;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int papC = sc.nextInt();
			int papR = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for (int c = papC; c < papC + width; c++) {
				for (int r = papR; r < papR + height; r++) {
					map[c][r] = i; //i를 쓰면 겹치면 나중껄로 겹칠 수 있음
				}
			}
		}
		for (int z = 1; z <= N; z++) {
			cnt = 0;
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if (map[i][j] == z) // 써진 i개수 세서 출력
						cnt++;
				}
			}
			System.out.print(cnt + "\n");
		}
	}// end of main
} // end of class
