package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class Main_jungol_조커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 숫자 개수
		int card[] = new int[N];
		int zero = 0;
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
			if (card[i] == 0) {
				zero++;
			}
		} /// 입력받고 0 개수 카운트 //

		int result = 0, gap = 0;
		Arrays.sort(card); // 오름차순 정렬
		if (zero == N) {
			System.out.println(zero);
			return;
		} // 모든게 다 0이면 배열 숫자 수만큼 리턴 하고 끝
		
		for (int i = zero; i < N; i++) {
			int size = 1; // 스트레이트 수
			int rezero = zero;
			for (int j = i; j < N - 1; j++) {
				gap = card[j + 1] - card[j];
				if (gap == 1) {
					size++;
					continue;
				} else if (gap > 1) {
					if ((gap - 1) > rezero) {
						size += rezero;
						rezero = 0;
						break;
					} else {
						size += gap;
						rezero -= (gap - 1);
					}
				}
			}
			size += rezero;
			result = Math.max(result, size);
		}
		System.out.println(result);

	}// end of main

}// end of class
