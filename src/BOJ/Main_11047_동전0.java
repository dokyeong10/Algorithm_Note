package BOJ;

import java.util.Scanner;

public class Main_11047_동전0 {
	public static void main(String[] args) {
		Scanner
		sc= new Scanner(System.in);
		int N =sc.nextInt(); // 동전 개수
		int K =sc.nextInt(); //돈합
		int arr[] = new int [N];
		int count =0;
		
		for (int i = 0; i < N; i++) {
			int moy =sc.nextInt(); // 돈 입력
			arr[i]= moy;
			
		}
		for (int i = N-1; i >=0; i--) { //큰 수부터 나누기 
			if(arr[i]<=K) { // 동전이 합보다 작을 경우 
				count +=(K/arr[i]);
				K=K%arr[i];
			}
			
		}
		System.out.println(count);
	}

}
