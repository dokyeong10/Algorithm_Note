package BOJ;

import java.util.Scanner;

public class Main_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 킬로그램
		int result = N / 5;

		if (N % 5 == 0) { //최소 개수 구하기 위해 5부터 
			System.out.println(N / 5);
			return;
			
		} else {
			for (int i = result; i > 0; i--) {
				int temp = N - (i * 5); //5로 나누고 나머지가 3으로 나눠지면 
				if (temp % 3 == 0) { 
					System.out.println(i + (temp / 3));
					return;
				} // 안나눠지면 몫 하나씩 줄이고 다시 
			}
		}
		if (N % 3 == 0) {
			System.out.println(N / 3);
			return;
		} else {
			System.out.println(-1);
		}

	}// end of main
}// end of class
