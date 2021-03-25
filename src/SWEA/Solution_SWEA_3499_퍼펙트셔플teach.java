package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N = 짝수 인 경우 6 0 1 2 for, 0 <=i<N/2 3 4 5 차이값 diff = (N+1)/2;
 * 
 * N = 짝수 인 경우 5 0 1 2 for, 0 <=i<N/2 N/2는 맨 마지막에 한번만 따로 3 4 차이값 diff = (N+1)/2;
 * 
 */
public class Solution_SWEA_3499_퍼펙트셔플teach {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine()); // 개수1<=N<=1000
			String[] srr = br.readLine().split(" "); // 띄어쓰기로 구분한다.

			sb.append("#").append(test_case);
			int diff = (N + 1) / 2;
			for (int i = 0; i < N / 2; i++) {
				sb.append(" ").append(srr[i]).append(" ").append(srr[i + diff]);
			}
			if (N % 2 != 0) {
				sb.append(" ").append(srr[N / 2]);
				
			}
			sb.append("\n");

		} // end of tc
		System.out.println(sb);

	}

}
