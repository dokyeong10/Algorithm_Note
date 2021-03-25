package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String N = sc.next();
			int cnt = 0;
			int p[] = new int[N.length()];
			for (int i = 0; i < N.length(); i++) {
				p[i] = N.charAt(i) - '0';
			}

			for (int i = 0; i < p.length; i++) {
				if (p[i] == 0) {
					continue;
				} else {
					cnt++;
					for (int j = i; j < p.length; j++) {
						if (p[j] == 1) {
							p[j] = 0;
						} else {
							p[j] = 1;
						}

					}
				}
			}
			boolean check =false;
			for (int i = 0; i < p.length; i++) {
				if (p[i] == 1) {
					check =false;
				} else {
					check =true;
				}
			}
			if(check) {
				System.out.println("#"+test_case+" "+cnt);
			}

		} // end of tc
	}// end of main
} // end of class
