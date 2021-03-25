package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= 10; test_case++) {

			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			int M = Integer.parseInt(br.readLine());
			int fly[][] = new int[M][M];
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 구분자
			for (int i = 0; i < N; i++) { // 제일 큰 배열 입력받기 
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max =Integer.MIN_VALUE;
			int sum[];
			

		} // end of tc

	} // end of main

}// end of class
