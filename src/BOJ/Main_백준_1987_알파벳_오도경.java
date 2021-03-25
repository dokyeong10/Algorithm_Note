package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1987_알파벳_오도경 {
	static int R, C, ans, cnt;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };// 상하좌우
	static int dc[] = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		map = new char[R][C]; // 배열
		visited = new boolean[R][C]; // 방문했는지
		check = new boolean[100]; // 같은 영어인지

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		} //////// d입력받기 //////////

		DFS(0, 0);
		System.out.println(ans + 1); // 처음시작포함 +1함
	}// end of main

	private static void DFS(int x, int y) {
		ans = Math.max(cnt, ans);
		visited[x][y] = true;
		check[map[x][y]] = true;

		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && !check[map[nr][nc]]) {
				cnt++;
				visited[nr][nc] = true; // 방문 표시
				check[map[nr][nc]] = true; // 문자사용표시
				DFS(nr, nc);
				visited[nr][nc] = false;
				check[map[nr][nc]] = false;
				cnt--;
			}
		}

	}

}// end of class
