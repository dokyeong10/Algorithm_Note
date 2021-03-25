package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1954_달팽이숫자_오도경 {

	static int[][] arr;
	static int[] dr = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 1; 
		int T = sc.nextInt(); //테케수
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); //사각형 크기
			arr = new int[N][N];

			int row = 0; // 행
			int col = 0; // 열
			int dir = 0; // 방향 디폴트 우
			
			if(N==1) {
				System.out.println("#"+test_case);
				System.out.println(1);
				continue;
			}

			for (int i = 0; i < N*N; i++) {
				arr[row][col] = i + 1;
				row += dr[dir]; // 방향 이동
				col += dc[dir];
				if (row >= N || col >= N || row < 0 || col < 0) { // 범위를 벗어나면
					row -= dr[dir]; //틀린거 제거 
					col -= dc[dir];
					dir = (dir + 1) % 4; // 우-하, 하 -좌, 좌-상,상-우로 방향 바꾸기 

					row += dr[dir];
					col += dc[dir]; // 바꾼 방향으로 이동
				}
				if (arr[row][col] != 0) { //이미 숫자가 있으면 방향 바꾸기 
					row -= dr[dir];
					col -= dc[dir];
					dir = (dir + 1) % 4; // 우-하, 하 -좌, 좌-상,상-우

					row += dr[dir];
					col += dc[dir]; // 바꾼 방향으로 이동
				}

			}
			System.out.println("#"+test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}

			

		} // end of TC

	}// end of main

}// end of class
