package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*  
 * 1차원 배열로 상자의 높이 카운팅해서 저장(메모리 절약, 시간절약)
 * 가장 높은 칸 => 가장낮은 칸으로 이동
 * 덤프 작업 반복( 덤프회수를 다 쓰기까지; 평탄화가 완료될때까지)
 * 
 * 입력 후 정렬
 * 덤프시 마다 정렬
 * 
 * 
 * */
public class Solution_SWEA_1208_Flatten {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 덤프 횟수 1<=n <=1000 br.reaadLine 은 문자열로 들어온다.
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 문자열로 들어오면 빈칸으로 쪼갠다.

			int[] arr = new int[100]; // 상자의 높이, 입력받은 높이를 직접 배열에 저장
			int sum = 0; // 상자의 총 개수
			for (int i = 0; i < 100; i++) { // 입력 받기
				int x = Integer.parseInt(st.nextToken());
				arr[i]=x;

				sum += x;
			}
			int target = 1; // 평탄화 작업의 목표치(최대 -최소)
			if (sum % 100 == 0) {
				target = 0;
			}
			/*정렬
			 * 카운팅정렬 : N
			 * 퀵정렬, 병합정렬, 힙정렬, 쉘정렬: NlogN - ex) Arrays.sort( )
			 * 삽입정렬, 선택정렬, 거품정렬 : N^2
			 * 
			 * max, min : N
			 * 
			 * 
			 * */
			
			Arrays.sort(arr); // 오름차순 0번칸에는 가장작은값 . [99] 가장 큰값

			for (int i = 0; i < n && arr[99] - arr[0] > target; i++) {// 덤프 , 평탄화 작업의 목표에 도달하면 종료
				arr[99]--; //가장 높은 칸 박스 하나 뻄
				arr[0]++; //가장 낮은칸 박스하나 증가
				Arrays.sort(arr); //덤프 후 재정렬
				
			}
			sb.append("#").append(test_case).append(" ").append(arr[99]-arr[0]).append("\n");

//			System.out.println("#"+test_case+ " "+ (max-min));

		} // end of TC
		System.out.print(sb);

	}// end of main

} // end of class
