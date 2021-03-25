package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_SWEA_1954_달팽이숫자_오도경teach {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테케수
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 사각형 크기
			int[][] m = new int[N][N];

			int r = 0; // 행
			int c = 0; // 열
			int size = N - 1; // 전진할 개수
			int num = 1; // 저장할 숫자

			while (size > 0) {// 시계방향회전
				for (int i = 0; i < size; i++) { // 오른쪽
					m[r][c] = num++;
					c++;
				}
				for (int i = 0; i < size; i++) { // 아래
					m[r][c] = num++;
					r++;
				}
				for (int i = 0; i < size; i++) { // 왼쪽
					m[r][c] = num++;
					c--;
				}
				for (int i = 0; i < size; i++) { // 위쪽
					m[r][c] = num++;
					r--;
				}
				size -= 2;// 이동할 크기
				r++; // 좌표시작 위치 수정
				c++;

			} // end of while
			if (N % 2 != 0) {
				m[r][c] = num;
			}
//			for (int i = 0; i < m.length; i++) {
//				System.out.println(Arrays.toString(m[i]));
//			}
			sb.append("#").append(test_case).append("\n");
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					sb.append(m[i][j]).append(" ");
				}sb.append("\n");
			}

		} // end of TC
		System.out.println(sb);

	}// end of main

}// end of class
