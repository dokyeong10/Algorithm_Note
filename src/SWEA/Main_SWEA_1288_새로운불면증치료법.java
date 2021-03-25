package SWEA;

import java.util.Scanner;

public class Main_SWEA_1288_새로운불면증치료법 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= 100; test_case++) {
			String N = sc.next();
			int n = Integer.parseInt(N);
			int cnt = 0;
			boolean check[] = new boolean[10];

			int num = 1; // 커지면서 곱해주는 값
			while (true) {
				for (int i = 0; i < N.length(); i++) {
					int tmp = N.charAt(i) - '0';
					if (check[tmp] == false) {
						cnt++;
						check[tmp] = true;
					}
				}
				if (cnt == 10) {
					break;
				} else {
					num++;
					N = Integer.toString(n * num);
				}

			}
			System.out.println("#" + test_case + " " + N);

		} // end of tc
	}// end of main

}// end of class
