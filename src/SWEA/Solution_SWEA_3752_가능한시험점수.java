package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3752_가능한시험점수 {
	static int N, Answer;
	static int score[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			score = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int total = 0;
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				total += score[i];
			}
			// 맞을 수 있는 점수들을 표현해줄 배열
			visited = new boolean[total + 1];

			Answer = 0;
			visited[0] = true;// 0점은 언제나 존재한다.
			solve(0, total);
			sb.append("#").append(test_case).append(" ").append(Answer).append('\n');
		}
		System.out.println(sb);

	}// end of main

	static void solve(int n, int max) {
		if (n == N) {
			// 끝~~ --> 결과확인 -배열에 몇개가 체크되어있는지 살펴보자.
			for (boolean bool : visited) {
				if (bool) {
					Answer++;
				}
			}
			return;
		}

		for (int i = max; i >= 0; i--) {
			if (visited[i]) {
				visited[i + score[n]] = true;
			}
		}
		solve(n + 1, max);
	}

} // end of calss
