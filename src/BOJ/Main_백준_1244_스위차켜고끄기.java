package BOJ;

import java.util.Scanner;

public class Main_백준_1244_스위차켜고끄기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt() + 1; // 스위치 개수
		int p[] = new int[N]; // 스위치 나타내는 상태

		for (int i = 1; i < N; i++) {
			p[i] = sc.nextInt();
		}
		int num = sc.nextInt(); // 학생 수
		for (int i = 1; i <= num; i++) {
			int sex = sc.nextInt();
			int number = sc.nextInt();

			if (sex == 1) { // 남자
				for (int j = number; j < N; j += number) {
					p[j] ^= 1;
				}
			} else if (sex == 2) {
				int Lnumber = number - 1;
				int Rnumber = number + 1;
				while (true) {
					if (Lnumber < 1 || Rnumber >= N) 
						break;
					
					if (p[Lnumber] != p[Rnumber]) {
						break;
					}
					Lnumber--;
					Rnumber++;
				}
				Lnumber++;
				Rnumber--;
				for (int j = Lnumber; j <= Rnumber; j++) {
					p[j] ^= 1;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			System.out.print(p[i] + " ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}// end of main
}// end of class
