package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식 {
	static int food[][];
	static int min=Integer.MAX_VALUE;
	static int N;
	static boolean check[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 개수
		food = new int[N][2]; 
		check = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			food[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			food[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		} /// 신맛 쓴맛 입력받기
		sub(0, 0, 1, 0);
		System.out.println(min);
	}// end of main

	static void sub(int cnt, int idx, int sour, int bitter) {
		if (cnt == N) {
			return; // 모든 경우의 수 확인 완료
		}
		for (int i = idx; i < N; i++) {
			if (check[i])
				continue;

			check[i] = true;
			sub(cnt + 1, i + 1, sour * food[i][0], bitter + food[i][1]);
			int temp = Math.abs((sour * food[i][0]) - (bitter + food[i][1])); // 절대값
			min = Math.min(temp, min);
			check[i] = false;

		}

	}// end of sub

}// end class
