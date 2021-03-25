package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_10966_물놀이를가자 {

	static int N, M;
	static char map[][]=new char[1001][1001];
	static int visit[][] = new int[1001][1001];
	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지도 행
			M = Integer.parseInt(st.nextToken()); // 지도 열
			
			Queue<Point> q = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'W') {
						q.offer(new Point(j, i));
						visit[i][j] = 1;

					}
				}
			} // 입력 받기 완료

			while (!q.isEmpty()) {
				Point cur = q.poll();
				for (int i = 0; i < 4; i++) {
					Point nxt = new Point(cur.x + dr[i], cur.y + dc[i]);
					if (nxt.x >= M || nxt.y >= N || nxt.x < 0 || nxt.y < 0)
						continue; // 배열의 범위를 벗어났을 때
					if (map[nxt.y][nxt.x] == 'W')
						continue; // 이동점이 w일 경우
					if (visit[nxt.y][nxt.x] != 0)
						continue; // 이미 방문했을 경우
					visit[nxt.y][nxt.x] = visit[cur.y][cur.x] + 1;
					q.offer(nxt);

				}

			}
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'L') {
						answer += visit[i][j] - 1; // 처음 시작을 1로 놔서 결과는 -1해줘야함
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append('\n');
			clear();

		}
		System.out.println(sb);
	}// end of main

	static void clear() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = 0;
			}
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}// end of class
