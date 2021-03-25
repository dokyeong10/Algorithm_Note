package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*  
 * 1차원 배열로 상자의 높이 카운팅해서 저장(메모리 절약, 시간절약)
 * 가장 높은 칸 => 가장낮은 칸으로 이동( max, min 변수 활용해서 시간 절약) 
 * 덤프 작업 반복( 덤프회수를 다 쓰기까지; 평탄화가 완료될때까지)
 * 
 * 
 * */
public class Solution_SWEA_1208_Flatten2_2 {
	static int Dump;
	static int height[] = new int[100];

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/s_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 덤프 횟수 1<=n <=1000 br.reaadLine 은 문자열로 들어온다.
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 문자열로 들어오면 빈칸으로 쪼갠다.

			int[] cnt = new int[101]; // 상자의 높이를 카운팅, 0index는 안쓴다.
			int max = 1; // 1<= 상자높이 <=100
			int min = 100;
			int sum = 0; // 상자의 총 개수
			for (int i = 0; i < 100; i++) { // 입력 받기
				int x = Integer.parseInt(st.nextToken());
				cnt[x]++;
				if (max < x) {
					max = x;
				}
				if (min > x) {
					min = x;
				}
				sum += x;
			}
			int target = 1; // 평탄화 작업의 목표치(최대 -최소)
			if (sum % 100 == 0) {
				target = 0;
			}
			for (int i = 0; i < n && max - min > target; i++) {// 덤프 , 평탄화 작업의 목표에 도달하면 종료
				cnt[max]--; // 가장높은 박스를 하나 뺌
				cnt[max - 1]++; // 한박스 뺏으므로 낮은 충 하나 추가
				cnt[min]--; // 가장 낮은 위치에 박스를 쌓을거니까, 낮은 높이 하나 없어짐
				cnt[min+1]++;
				if (cnt[max] == 0) {max--;	}
				if (cnt[min] == 0) {min++;	}
			}
			sb.append("#").append(test_case).append(" ").append(max-min).append("\n");
		
//			System.out.println("#"+test_case+ " "+ (max-min));

		} // end of TC
		System.out.print(sb);

	}// end of main

} // end of class
