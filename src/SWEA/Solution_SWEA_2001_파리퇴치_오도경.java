package SWEA;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_오도경 {
	public static void main(String[] args) throws Exception {
	 Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= 10; test_case++) {

			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			int M = sc.nextInt();
			int fly[][] = new int[M][M];
			int max =0;
			for (int i = 0; i < N; i++) { // 배열 입력
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}	
			for (int i = 0; i < N-M+1; i++) {// 한쪽끝은 제외해도 더해짐 
				for (int j = 0; j < N-M+1; j++) {
				int sum=0;
					for (int k = 0; k < M; k++) {
						for (int k2 = 0; k2 < M; k2++) {
							sum+=arr[i+k][j+k2];
						}
					}
					if(max<sum) {
						max=sum;
					}
					
				}
				
			}
			System.out.println("#"+test_case+" "+max );
			

		} // end of tc

	} // end of main

}// end of class
