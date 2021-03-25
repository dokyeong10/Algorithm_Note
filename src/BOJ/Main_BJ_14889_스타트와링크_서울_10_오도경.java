package BOJ;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main_BJ_14889_스타트와링크_서울_10_오도경 {
	private static int N, min;
	private static int[][] team;
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 팀 개수
		team = new int[N + 1][N + 1]; // 팀 점수 배열
		visit = new boolean[N + 1]; // 중복 체크

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				team[i][j] = sc.nextInt();
			}
		} // 입력받기 완료//

		min = Integer.MAX_VALUE;
		comb(1, 0); // 조합이용
		System.out.println(min);

	} // end of main

	static void comb(int start, int depth) {

		if (depth == N / 2) {
			min = Math.min(min, Difference());
			return;
		}

		for (int i = start; i < N + 1; i++) {
			if (visit[i] != true) {
				visit[i] = true;
				comb(i + 1, depth + 1);
				visit[i] = false;
			}

		}

	}

	static int Difference() { // 차이 구하는 함수

		int startteam = 0;
		int linkteam = 0;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (visit[i] && visit[j]) { //true 일때
					startteam += team[i][j];
				}
				if (visit[i] != true && visit[j] != true) {//false 일때 
					
					linkteam += team[i][j];
				}
			}
		}

		return Math.abs(startteam - linkteam);
	}
} // end of class
