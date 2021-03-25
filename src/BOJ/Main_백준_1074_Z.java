package BOJ;

import java.util.Scanner;

public class Main_백준_1074_Z {
	private static int N;
	private static int r;
	private static int c;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 배열 크기
		r = sc.nextInt(); // 행
		c = sc.nextInt(); // 열

		go(N, 0, 0);
	} // end of main

	private static int[] bin = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768 };

	// 사각영역의 가로세로 크기 = 2^n, 사각영역의 시작위치 =(sr,sc)
	static void go(int n, int sr, int sc) {
		if (n == 0) { // 한칸짜리일때 종료조건
			if (sr == r && sc == c) {
				System.out.println(cnt);
				System.exit(0); // 프로그램 종료

			}
			cnt++;
			return;
		}
		// 동일한 수식 (int) Math.pow(2, n - 1)한번만 계산해서 재사용
		// 직접 2^n을 구하자 => 분할정복 => 미리 다 구해놓자 (hashing)
		//n-1연산도 저장하고 사용 
		// 수학공식
		int x =  bin[n-1]; //(int) Math.pow(2, n - 1); 로 바꿔도 됨 
		go(n - 1, sr, sc); // 좌상
		go(n - 1, sr, sc + x); // 우상
		go(n - 1, sr + x, sc); // 좌하
		go(n - 1, sr + x, sc + x); // 우하

	}

}// end of class
