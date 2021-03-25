package SWEA;

/**
 * 큐를 사용해서 FM대로 시물레이션 함
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기2teach {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
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

			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) {
				q.offer(arr[i]); // q에 데이터 8개 입력
			}

			ex: while (true) {
				for (int i = 1; i <= 5; i++) { // 감소시킬 숫자
					int num = q.poll(); // 큐에서 숫자꺼내기
					num -= i;// 꺼낸 숫 자 i만큼 숫자 감소
					if (num <= 0) {// 0이하면 종료
						num = 0;
						q.offer(num);
						break ex; // 라벨 붙여서 while문을 빠져나감
					}
					q.offer(num);// 감소시킨 숫자를 큐에 넣기
				}
			}
			sb.append("#").append(test_case);
			while (!q.isEmpty()) {
				sb.append(" ").append(q.poll());
			}
			sb.append("\n");

		} // end of tc
		System.out.println(sb);

	} // end of main

}// end of class
