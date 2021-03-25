package BOJ;

import java.util.Scanner;

public class Main_4344_평균은넘겠지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케
		for (int test_case = 0; test_case < T; test_case++) {
			int stu = sc.nextInt(); // 학생수
			int sum = 0;
			int score[] =new int[stu] ;
			int high = 0;
			double result = 0;

			for (int i = 0; i < stu; i++) {
				score[i] = sc.nextInt();
				sum += score[i];
			}
			double avg = (double) sum / stu;
			for (int i = 0; i < stu; i++) {
				if (score[i] > avg) {
					high++;
				}
			}

			result = (double) high*100 / stu;
			System.out.printf("%.3f%%\n", result);

		}
	}

}
