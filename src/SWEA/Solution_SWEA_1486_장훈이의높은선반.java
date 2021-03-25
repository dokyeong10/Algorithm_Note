package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1486_장훈이의높은선반 {

	static int T, N, H;
	static int[] heights;
	static int Min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			heights = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			///// 입력완료/////
			// 부분집합 -> H를 넘는 가장 작은 수 ?

			Min = Integer.MAX_VALUE;
			byBitMasking();
			sb.append("#").append(test_case).append(" ").append(Min).append('\n');

		} // end of tc
		System.out.println(sb);

	}// end of main

	static void byBitMasking() {
		// 1<N--> 비트를 왼쪽으로 --> x2 이것을 결국 2^n

		for (int i = 1; i < (1 << N); i++) { // i 요소의 포함 상태를 비트적으로 나타낸다
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) { // i에j비트가 포함되어 있다면..
					sum += heights[j];
					// 이미 만족했다면 더 계속더해줄 필요는 없다.
					if (sum - H > Min) {
						break;
					}

				}
			} // for₩1
			if (sum >= H && sum - H < Min) {
				Min = sum - H;

			}
		}

	}

}// end of class
