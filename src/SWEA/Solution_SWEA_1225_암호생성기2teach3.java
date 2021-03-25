package SWEA;

/**
 *배열에 8개 값을 넣어놓고, 큐처럼꺼내서 숫자 뺼셈후 다시 삽입하는 작업을 하지 않고,
 *작업한 index의 위치관리(end)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기2teach3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int test_case = 1; test_case <= 10; test_case++) {

			int N = Integer.parseInt(br.readLine());
			
			int arr[] = new int[8];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			int v = (min - 1) / 15 * 15;// 뺄값
			for (int i = 0; i < arr.length; i++) {
				arr[i] -= v;
			}

			int end = 0; // 작업할 위치 (작업후에는 끝 위치로 감 index)
			ex: while (true) {
				for (int i = 1; i <= 5; i++) { // 감소시킬 숫자
					arr[end] -= i; // 작업칸에서 숫자빼기
					if (arr[end] <= 0) { // 0이하면 종료
						arr[end] = 0;
						break;
					}
					end++; // 작업할 칸 index 만 옆으로 이동
					if (end == 8) {
						end = 0;
					}
				}
				
		
			sb.append("#").append(test_case);
				for (int i = 0; i < end; i++) { //첫칸 (end+1)~ 배열 끝까지
				sb.append(" ").append(arr[i]);
			}
			sb.append("\n");
		}
			

		} // end of tc
		System.out.println(sb);

	} // end of main

}// end of class
