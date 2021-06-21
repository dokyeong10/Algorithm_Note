package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Dot {
	int x;
	int y;

	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BJ_2178_미로탐색2 {

	static int dr[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dc[] = { 0, 0, -1, 1 };
	static int grid[][];
	static boolean[][] checked; // 확인

	static int N;
	static int M;

	public static void bfs() {

		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(1, 1)); //1,1에서 출발,저장
		checked[1][1] = true; //1,1도 횟수에 포함

		// 큐가 끝날때까지
		while (!q.isEmpty()) {
			Dot d = q.poll(); //다중입출력, 행과 열 한번에!
			int cnt = grid[d.x][d.y] + 1;

			for (int i = 0; i < 4; i++) {
				int nr = d.x + dr[i];
				int nc = d.y + dc[i]; // 상하좌우 확인

				if (0 < nr && nr <= N && 0 < nc && nc <= M) { //이동을 했을 때 배열  범위에 들어간다면
					if (grid[nr][nc] != 0 && !checked[nr][nc]) { // 0이 아니고, 이미 들렀던곳이 아니면 
						checked[nr][nc] = true;
						grid[nr][nc] = cnt;
						q.offer(new Dot(nr, nc)); //이동
					}
				}
			}
		}

	}// end of bfs(x,y)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		grid = new int[N + 1][M + 1]; // 배열
		checked = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String input = sc.next(); 

			for (int j = 1; j <= M; j++) {

				grid[i][j] = input.charAt(j - 1) - '0';

			}

		}

		bfs();
		System.out.println(grid[N][M]); //출력

	}// end of main
} // end of class

/*
 * DFS stack 혹은 재귀함수로 구현. -경로 탐색을 할 때 한 방향으로 갈 수 있을때까지 계속 가다가 더 이상 갈 수 없게되면 다른
 * 방향으로 다시 탐색을 진행 모든 노드를 방문하는 경우 사용 시간 복잡도 : 인접리스트 o(V+E), 인접행렬 o(V^2)
 *
 * BFS Queue사용해서 구현 시간복잡도 : 인접리스트 : o(V+E), 인접 행렬 o(V^2) 효과적으로 사용할 경우 1.최소 비용문제
 * 2. 선의 가중치가1인 경우 3.정점과 간선의 개수가 적다(시간제약 메모리 제한 내에 만족한다.)
 *
 * 2178번은 최단거리이기때문에 BFS사용
 *
 *
 *
 *
 *
 */
