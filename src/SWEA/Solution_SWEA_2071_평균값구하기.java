package SWEA;
import java.util.Scanner;

public class Solution_SWEA_2071_평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= 3; test_case++) {
			int N[] = new int[10];
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				N[i] = sc.nextInt();
				sum += N[i];
			}
			int avg =(int)Math.round((double)sum/10);
			System.out.println("#"+test_case+" "+avg);

		}
	}

}
