package SWEA;

import java.util.Scanner;

public class Solution_SWEA_3289_서로소집합 {
	static int N;
	static int parents[];

	static void make() { // 크기가 1인 단위집합을 만든다.
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return;
		parents[bRoot] = aRoot;

	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			sb.append("#").append(test_case).append(" ");

			

			N = sc.nextInt(); // a b 최대 범위

			int M = sc.nextInt(); // 개수
			parents = new int[N + 1];
			
			make();
			for (int i = 0; i < M; i++) {
				int cal = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (cal == 0) {
					union(a, b);
				} else {
					if (findSet(a) == findSet(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}

			}
			sb.append('\n');

		} // end of tc
		System.out.println(sb);
	} // end of main

}// end of class
