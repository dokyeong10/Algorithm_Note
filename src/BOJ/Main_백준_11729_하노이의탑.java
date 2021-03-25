package BOJ;

import java.util.Scanner;

public class Main_백준_11729_하노이의탑 {

	
	static int a =0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(a);
		hanoi(n, 1, 2, 3);
		

	}

	private static void hanoi(int cnt, int from, int temp, int to) {

		if (cnt == 0)
			return;
		a++;

		// n-1개 원판 이동

		hanoi(cnt - 1, from, to, temp);

		System.out.println(from + " " + to);
		
		hanoi(cnt - 1, temp, from, to);

	}

}

