package BOJ;

import java.util.Scanner;

public class Main_백준_1244_스위치켜고끄기_오도경 {
	static int[] arr; // 스위치 번호
	static int num, stunum; // 스위치, 학생수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		num = sc.nextInt() + 1; // 스위치 개수

		arr = new int[num]; // 스위치 열

		for (int i = 1; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		stunum = sc.nextInt(); // 학생수

		for (int i = 1; i <= stunum; i++) {
			int se = sc.nextInt(); // 성별 남 : 1, 여:2
			int ber = sc.nextInt(); // 받은 번호

			// 남자일때
			if (se == 1) {
				for (int j = ber; j < num; j += ber) {
					arr[j] ^= 1;
				}

			} // 여자일때
			else if (se == 2) {
				int Lber = ber - 1; // 대칭 왼쪽
				int Rber = ber + 1; // 대칭 오른쪽
				while (true) {
					if (Lber < 1 || Rber >= num)
						break;

					if (arr[Lber] != arr[Rber]) {
						break;
					}
					Lber--;
					Rber++;
				}
				Lber++;
				Rber--;
				for ( ; Lber <= Rber; Lber++) {
					arr[Lber] ^= 1;
				}
			}

		}
		for (int i = 1; i < num; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}// end of main

} // end of class
