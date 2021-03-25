package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val = sc.nextInt(); // 참외 면적당 개수
		int dir[] = new int[6];
		int hei[] = new int[6];
		int mul[] = new int[6];
		for (int i = 0; i < 6; i++) {
			dir[i] = sc.nextInt(); // 방향
			hei[i] = sc.nextInt(); // 길이
		}
		int max = 0;
		int min = 0;
		for (int i = 0; i < 6; i++) {
			if (i == 5) {
				mul[i] = hei[i] * hei[0];
			}
			if (i < 5) {
				mul[i] = hei[i] * hei[i + 1];
			}
			max = Math.max(max, mul[i]);////// 가장 큰 넓이 구하기 ///
		}
		for (int i = 0; i < 6; i++) {
			if (mul[i] == max) {
				if (i < 3) {
					min = mul[i + 3];
				} else {
					min = mul[i - 3];
				}
			}
		}
//		System.out.println(max);
//		System.out.println(min);
		System.out.println((max - min) * val);

	} // end of main
} // end of class
