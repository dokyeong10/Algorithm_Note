package BOJ;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main_백준_3040_백설공주와일곱난쟁이_오도경 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int realseven[] = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			realseven[i] = sc.nextInt();
			sum += realseven[i];
		} // 9난쟁이 입력받기

		int result = sum - 100;

		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (realseven[i] + realseven[j] == result) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							System.out.println(realseven[k]);
						}
					}
				} else
					continue;
			}
		}

	}// end of main
}// end of class
