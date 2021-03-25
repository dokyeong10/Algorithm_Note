package SWEA;

import java.util.Scanner;

public class Solution_SWEA_1289_원재의메모리복구하기_D3 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
//		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String bit = sc.next(); // "0011"
			int count = 0; // 바꿔야할 횟수를 카운팅할 변수

			char pre = '0';
			for (int i = 0; i < bit.length(); i++) {
				if (pre != bit.charAt(i)) {
					count++;
					pre = bit.charAt(i);
				}

			}

			System.out.println("#" + test_case + " " + count);
		} // end of tc
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + "ms"); // 시간 재는 것

	}// end of main

} // end of class
