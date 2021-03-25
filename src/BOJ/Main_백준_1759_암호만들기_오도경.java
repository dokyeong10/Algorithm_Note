package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * dfs 이용
 * 
 * 문제 요약 
 *C개 중 L 개
 *모음 1개이상  자음 2개이상
 *오름차순정렬
 * */
public class Main_백준_1759_암호만들기_오도경 {

	static int L, C;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 사용해야할 알파벳 수
		C = Integer.parseInt(st.nextToken()); // 주어진 알파벳 수

		arr = new char[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);

		} // 입력 받기

		Arrays.sort(arr); // 오름차순 정렬
		dfs(0, 0, 0, "");
		System.out.println(sb);

	}// end of main

	private static void dfs(int i, int mo, int ja, String word) {
		if (mo + ja == L) { // 모음 자음 합이 사용해야할 알파벳 수
			if (mo >= 1 && ja >= 2) { // 모음 1개이상, 자음 2개 이상
				sb.append(word).append('\n');
			}
			return;
		}

		for (int j = i; j < C; j++) {
			char pw = arr[j];
			if (pw == 'a' || pw == 'e' || pw == 'i' || pw == 'o' || pw == 'u') { //모음일경우
				dfs(j + 1, mo + 1, ja, word + pw);

			} else { //자음일 경우 
				
				dfs(j + 1, mo, ja + 1, word + pw);
			}
		}

	}

} // end of class
