package JUNGOL;

import java.util.Arrays;
import java.util.Scanner;

public class Main_JUNGOL_1205_조커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 카드 개수
		int card[] = new int[N];
		int cnt0 = 0;
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
			if (card[i] == 0) { // 카드가 0이면 횟수 추가
				cnt0++;
			}

		} // 입력받기
		Arrays.sort(card); // 오름 차순 정렬
		if (cnt0 == N) { // 모두 0일떄
			System.out.println(N);
			return;
		}
		int result = 0, gap = 0;

		for (int i = cnt0; i < N; i++) {
			int size = 1; // 자기자신 있으니까 무조건 1로 시작
			int remainjo = cnt0; // 쓰고 남은 조커
			for (int j = i; j < N - 1; j++) {
				gap = card[j + 1] - card[j]; // 차이 구함

				if (gap == 1) {
					size++;
					continue;
				} else if (gap > 1) {
					if ((gap - 1) > remainjo) {
						size += remainjo;
						remainjo = 0;
						break;
					} else {
						size += gap;
						remainjo -= (gap - 1);
					}
				}
			}
			size += remainjo;
			result = Math.max(result, size);

		}
		System.out.println(result);
	}// end of main
}// end of class
