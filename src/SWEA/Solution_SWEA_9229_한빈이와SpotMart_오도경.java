package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_오도경 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 선택가능 과자수
			int M = Integer.parseInt(st.nextToken()); // 2개 과자 합 한도
			int chip[] = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {

				chip[i] = Integer.parseInt(st.nextToken());
			} // 입력 받기

			int c = -1; // 최소값

			for (int i = N - 1; i > 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (chip[i] + chip[j] <= M && chip[i] + chip[j] > c) { // 합한것이 한도보다 적고, 제일큰값 갱신
						c = chip[i] + chip[j];
					}

				}

			}
			sb.append("#").append(test_case).append(" ").append(c).append("\n");

		} // end of tc
		System.out.println(sb);
	} // end of main

}// end of class
