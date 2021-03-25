package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식teach {
	private static int N;
	private static int[] S;
	private static int[] B;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 재료의 개수 1~10
		S = new int[N]; // 신맛
		B = new int[N]; // 쓴맛
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		powerSet(0,1,0);
		System.out.println(min);

	}// end of main
	/*
	 * index : 차수 , sVal: 지금까지 사용한 재료들의 곱, bVal = 지금까지 사용한 재료들의 합 index 번째의 재료를
	 * 사용할지, 사용하지 않을지 결정
	 */
	public static void powerSet(int index, int sVal, int bVal) {
		if (index == N) {
			if (bVal == 0) {// 재료를 사용하지 않으면 리턴
				return;
			}
			// 신맛과 쓴맛의 차의 절대값을 최소값을 업데이트
			int result = Math.abs(sVal - bVal);
			if (min > result)
				min = result;
			return;
		}
		// index 번째 재료사용
		powerSet(index + 1, sVal * S[index], bVal + B[index]);

		// index 번째 재료 사용 안함
		powerSet(index + 1, sVal, bVal);
	}
}// end of class
