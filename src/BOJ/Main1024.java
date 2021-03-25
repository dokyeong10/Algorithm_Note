package BOJ;

import java.util.Arrays;
import java.util.Scanner;
// 메모리 초과 - 오류
public class Main1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정수의 합
		int L = sc.nextInt(); // 연속 수열 최소 개수
		int min = 100; // 100보다 작거나 같은 자연수

		int m = 0;

		int sum; // N과 비교할 합
		int count; // sum이 더해지는 횟수
		int[] arr = new int[N]; // 연속 숫자 저장 배열

		for (int i = 1; i < N / 2; i++) {
			sum = 0;
			count = 0;
			m = 0; //초기화

			 for (int j = i; j < N / 2; j++) { //1~9
				if (sum < N) { //입력된 합이  sum보다 클 때 , 합친 합이 최소 N의 반보다 커야함, L이 2보다 크거나 같은 값이기 때문에  
					sum += j;
					count++; //추가해줌
					if (sum == N) {// 같아졌을때 
						if (count >= L) {//합한 횟수가 100보다 작고 L보다 크거나 같다면
							Arrays.fill(arr, 0); // 0으로 초기화
							min = count; //min는 횟수
							m = i;//m에 맨처음 해당되는 숫자 저장

							for (int k = 0; k < count; k++) {
								arr[k] = m;
								m++; //연속된 수열이라서 ++해줌
							}

						} 
					}
				} else {
					break;
				}

			}

		}
		Arrays.sort(arr); // 오름차순 정렬

		if (arr[N - 1] == 0) { // 수열이 없으면 -1출력
			System.out.println(-1);
		} else {
			for (int i = 0; i < N; i++) {
				if (arr[i] != 0) {
					System.out.print(arr[i] + " "); //수열 저장 출력
				}

			}

		}

	} // end of main

}// end of class
