package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_메모이제이션 {
	/**
	 * 방문체크할 필요없음 모든방에서 출발해보기 메모이제이션 : 결과를 저장하고 재사용
	 * 
	 * (DFS-깊이 우선 탐색, BFS-너비 우선 탐색 - 1:N(비선형 자료구조)의 코딩 블럭)로 푸는 문제가 아니다. 이 문제는 선형
	 * 구조이다. 모든 정점에서 출발해서 다 탐색하봐야함. 최대값구하기(동일한 최대값일 경우, 숫자가 작은 경우를 택한다) 재귀함수 반복문
	 */

	static int dr[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dc[] = { 0, 0, -1, 1 };
	private static int N;
	private static int[][] A;
	private static int[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= 27; test_case++) {

			N = Integer.parseInt(br.readLine()); // 배열 크기 (1<=N<=10^3)

			A = new int[N][N];
			memo = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 배열안 숫자 저장 완료

			int max = 0; // 최대로 이동할 수 있는 방의 개수
			int num = Integer.MAX_VALUE; // 최대이동을 위해 출발할 방의 위치 (숫자)

			for (int r = 0; r < N; r++) { // 모든 방에서 출발해서 탐색해보자
				for (int c = 0; c < N; c++) {
					int val = go(r, c); // r,c 위치에서 출발해서 이동할 수 있는 최대 방의 개수를 리턴
					if (max < val || max == val && num > A[r][c]) {
						max = val;
						num = A[r][c];
					}

				}
			}

			sb.append("#").append(test_case).append(" ").append(num).append(" ").append(max).append("\n");

		} // end of tc
		System.out.println(sb);

	} // end of main

	/**
	 * A[r][c]방에서 출발해서 최대 이동할 수 있는 방의 개수를 리턴하는 메서드
	 * 
	 */
	private static int go(int r, int c) {
		if (memo[r][c] != 0) { // 탐색한 기록이 있는가 ?
			return memo[r][c];
		}
		 memo[r][c] = 1; // 몇칸 갈 수 있는지 저장할 변수
		int num = A[r][c];
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (0 <= nr && nr < N && nc < N && nc >= 0 && A[nr][nc] == num + 1) { // 이동할 수 있니 ?
				memo[r][c] += go(nr, nc); // 외길이니까
				break;

			}
		}

		return memo[r][c];
	}

} // end of class
