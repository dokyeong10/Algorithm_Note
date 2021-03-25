package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_6808_규영이와인영이의카드게임 {
	static int kunum[] = new int[9]; // 규영이 카드 번호
	static int innum[] = new int[9]; // 인영이 카드 번호
	static boolean[] check = new boolean[19];
	static boolean[] ch = new boolean[9];
	static int ans, cnt, mucnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ans = cnt = mucnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				kunum[i] = Integer.parseInt(st.nextToken());
				check[kunum[i]]=true; // 규영이가 낸건 true
			} ////// 규영이가 내는 카드번호 고정 입력
			
			int tmp=0;
			for (int i = 1; i <=18; i++) {
				if(!check[i])
					innum[tmp++]=i; //인영이 카드 
			}
			permu(0,0,0);

			sb.append("#").append(test_case).append(" ").append(ans).append(cnt-ans-mucnt).append("\n");
			// ans는 이긴수 cnt-ans-mucnt = 전체가지수에서 이긴거 비긴거 뺀것 
			
		} // end of tc
		System.out.println(sb);
	}// end of main

	 static void permu(int r, int sum1, int sum2) {
		 if(r==9) {// 9라운드가 끝나면 
			 cnt++; //모든 가지수 
			 if(sum1>sum2) ans++; //이긴수 
			 if(sum1==sum2) mucnt++; // 비긴수
			 return;
		 }
		 for (int i = 0; i < 9; i++) {
			if(!check[i]) {
				check[i]=true;
			}
		}
		
	}
} // end of class
