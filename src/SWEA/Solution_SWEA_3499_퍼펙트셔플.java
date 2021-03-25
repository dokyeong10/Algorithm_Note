package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			String[] num = new String[5000];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}

			Queue<String> q = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			for (int i = 0; i <= Math.round(N / 2) - 1; i++) {
				q.offer(arr[i]);
			}
			// 첫번째 큐 담기
			for (int i = Math.round(N / 2); i < N; i++) {
				q2.offer(arr[i]);
			}
			// 두번째 큐 담기
			
			
			
			while(!q.isEmpty()&&!q2.isEmpty()) {
				//System.out.println("#"+test_case+" "+);
			}
			

		} // end of tc

	}

}
