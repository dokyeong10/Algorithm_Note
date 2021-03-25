package BOJ;

import java.util.Scanner;

public class Main_백준_2775_부녀회장이될테야 {
	private static int N;
	private static int K;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T =sc.nextInt();
		for (int i = 1; i <= T; i++) {
			 K = sc.nextInt(); //층
			 N = sc.nextInt(); //호 
			System.out.println(go(K,N));
			
		} // end of tc 
	}

	static int go(int K, int N) { // 재귀함수사용 
		if (N == 0) {
			return 0;
		} else if (K == 0) { //0층 1호 =1명, 2호 =2명, 3호 =3명 ... 
			return N;
		} else {
			return go(K, N - 1) + go(K - 1, N);
		}

	}// end of main
} // end of class
