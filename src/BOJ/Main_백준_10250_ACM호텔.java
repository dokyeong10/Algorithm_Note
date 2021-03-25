package BOJ;

import java.util.Scanner;

public class Main_백준_10250_ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt(); // 호텔 높이
			int W = sc.nextInt(); // 호텔 호수 수
			int N = sc.nextInt(); // 손님 번호

			int first = N % H;
			int sec = (N / H) + 1;
			if (N % H == 0) {
				sec= N / H;
				first = H;
			}
			System.out.println(first * 100 + sec);

		} // end of tc
	} // end of main
}// end of class
