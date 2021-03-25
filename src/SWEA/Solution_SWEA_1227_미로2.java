package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1227_미로2 {
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int[][] map = new int[100][100];
	// 사방탐색
	// deltas의 순서를 지켰어야 하는 경험?
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	// 방문 여부 체크
	static boolean[][] visited;
	// 정답: 도달할 수 있으면 1, 그렇지 않으면 0
	static int Answer;

	public static void main(String[] args) throws IOException {
		 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			input.readLine();// 테케 번호 읽어서 버림
			visited = new boolean[100][100];
			int sr = 0;
			int sc = 0;
			for (int r = 0; r < 100; r++) {
				String line = input.readLine();
				for (int c = 0; c < 100; c++) {
					map[r][c] = line.charAt(c) - '0'; 

					if (map[r][c] == 2) {
						sr = r;
						sc = c;
					}
				}
			} // 입력 완료
			Answer = 0;
			
			byDfs(sr, sc);
			output.append("#").append(t).append(" ").append(Answer).append('\n');
		}
		System.out.println(output);
	}

	static void byDfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			if (map[nr][nc] == 0 & !visited[nr][nc]) {
				byDfs(nr, nc);
			} else if (map[nr][nc] == 3) {
				Answer = 1;
				return;
			}
		}
	}

	

}// end of class
