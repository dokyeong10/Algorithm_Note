package SWEA;

import java.io.*;
import java.util.*;

public class Solution_SWEA_5432_쇠막대기자르기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_쇠막대기.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			int tot = 0;
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(') {
					cnt++;
				} else { // ')'
					cnt--;
					if (s.charAt(i - 1) == '(')
						tot += cnt;
					else
						tot++;

				}
			}

			System.out.println("#" + test_case + " " + tot);
		}
		sc.close();

	}
}
