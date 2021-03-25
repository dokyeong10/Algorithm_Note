package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_15649_N과M { // 순열

	static int N, M;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.close();
		num = new int[N];
		visited = new boolean[N + 1];
		permutation(0);

	}

	static void permutation(int cnt) {
		if (cnt == N) {
			for (int i = 1; i < N; i++)
				System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			else {
				visited[i] = true;
				num[cnt] = i;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
