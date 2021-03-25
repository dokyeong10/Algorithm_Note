package BOJ;

import java.util.Scanner;

public class Main1929 { //소수구하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 입력 1
		int N = sc.nextInt(); // 입력 2
		boolean[] check = new boolean[N+1];
		check[0] = check[1] = true; // 0과 1은 true로 초기 설정

		// true = 소수 x , false = 소수
		for (int i = 2; i <= N; i++) {
			if (check[i] == true) {
				continue;
			}
			for (int j = i + i; j <= N; j = j + i) {//2,3,5,....N전의 배수들은 check[] =true가 된다.
				check[j] = true;                    // i+i 함으로 2,3,..범위에 포함되지 않을경우 소수 x

			}

		}
		for (int i = M; i <= N; i++) {
			if (check[i] == false) {
				System.out.println(i);
			}

		}
	}

}
