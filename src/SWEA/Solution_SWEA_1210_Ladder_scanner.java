package SWEA;
import java.util.Scanner;

/**
 * 사다리 가장아래 행의 목표지점(2위치)를 찾아서 거슬러 올라간다.
 *
 */
public class Solution_SWEA_1210_Ladder_scanner {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {

			int TC = sc.nextInt(); // 테스트 케이스 번호
			int[][] m = new int[100][102]; // 인덱스가 배열범위를 넘어가는 것을 방지하기 위해 좌우로 1열씩 여유칸을 둔다.

			for (int i = 0; i < m.length; i++) { // 행
				for (int j = 1; j <= 100; j++) { // 열1~100 0번과 101은 0으로 할 것이다.
					m[i][j] = sc.nextInt();

				}
			}
			int r = 99;
			int c = -1; // 쓰레기값일단 넣어둠

			for (int j = 1; j <= 100; j++) { // 마지막행에서만검사해서 2위치를 찾는다.
				if (m[99][j] == 2) {
					c = j; // 2의 위치 찾음.

				}
			}

			final int 상 = 1;
			final int 좌 = 2;
			final int 우 = 3;
			int dir = 상; // 방향, 최초 방향은 위로 시작

			while (r > 0) { // 아래서 올라가서 행이 0되면 끝
				if (dir != 우 && m[r][c - 1] == 1) { // 좌
					dir = 좌;
					c--;

				} else if (dir != 좌 && m[r][c + 1] == 1) {// 우
					dir = 우;// 우측으로 가기
					c++;

				} else { // 상
					dir = 상;// 위쪽으로 가기
					r--;
				}

			}
			System.out.println("#" + test_case + " " + (c - 1));

		} // end of tc

	}// end of main

} // end of class
