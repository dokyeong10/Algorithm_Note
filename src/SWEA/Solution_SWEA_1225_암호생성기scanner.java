package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEA_1225_암호생성기scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {
			Queue<Integer> que = new LinkedList<>();

			for (int i = 0; i < 8; i++) {
				int V = sc.nextInt();
				que.offer(V);
			}
			int val = 1;
			while (val != 0) {
				for (int j = 0; j < 6; j++) {
					val = que.poll();
					val -= j;
					if (val < 0) {
						val = 0;

					}
					que.offer(val);
					if (val == 0)
						break;
				}

			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 8; i++) {
				int a = que.poll();
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}

}
