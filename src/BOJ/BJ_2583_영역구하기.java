package BOJ;

import java.util.*;

public class BJ_2583_영역구하기 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int m;
    static int n;
    static int k;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();//행
        n = sc.nextInt();//열
        k = sc.nextInt(); //직사각형 개수
        map = new int[m][n];
        visited = new boolean[m][n];
        int count = 0; //영역 카운트
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < k; i++) {
            int lx = sc.nextInt(); // 왼쪽 위 x
            int ly = sc.nextInt(); // 왼쪽 위 y
            int rx = sc.nextInt(); // 오른쪽 아래 x
            int ry = sc.nextInt(); // 오른쪽 아래 y
            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    map[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) { //아직 방문하지 않고 0이면
                    int data = bfs(i, j); // 비에프에스 사용
                    list.add(data);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(list); //오름차순
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int curX = data[0];
            int curY = data[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }


}// end of class
