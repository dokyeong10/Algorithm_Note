package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {

	static boolean arr[][];
	static boolean visited[];
	private static int N, M, V;
	static StringBuilder sb =new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 번호

		arr = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from][to] = arr[to][from] = true;

		}
		visited = new boolean[N + 1];
		dfs(V);
		sb.append('\n');
		Arrays.fill(visited, false);

		bfs(V);
		System.out.print(sb);

	}// end of main

	private static void bfs(int current) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(current);
		visited[current] = true;

		while (!queue.isEmpty()) {
			 current = queue.poll();
			
			 sb.append(current).append(' ');

			for (int i = 1; i <=N; ++i) {
				if(arr[current][i]&&!visited[i]) {
					queue.offer(i);
					visited[i]=true;
				}
			}
		}

	}

	private static void dfs(int current) {
		visited[current] = true;
		sb.append(current).append(' ');
		
		for (int i = 1; i <= N; ++i) {
			if(arr[current][i]&&!visited[i]) {
				dfs(i);
			}
		}

	}

}// end of class
