package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author HEESOO
 *
 */
class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		q.offer(new Node(1,1));
		visit[1][1]=true;
		
		while(!q.isEmpty()) {
			Node node=q.poll();
			int cnt=map[node.x][node.y]+1;
			
			int[] dotX= {0,0,-1,1};
			int[] dotY= {-1,1,0,0};
			for(int i=0;i<4;i++) {
				int xx=node.x+dotX[i];
				int yy=node.y+dotY[i];				
				if(0<xx&&xx<=n&&0<yy&&yy<=m) {
					if(map[xx][yy]!=0&&!visit[xx][yy]) {
						visit[xx][yy]=true;
						map[xx][yy]=cnt;
						q.offer(new Node(xx, yy));
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		m=scan.nextInt();
		map=new int[n+1][m+1];
		visit=new boolean[n+1][m+1];
		for(int i=1;i<=n;i++) {
			String str=scan.next();
			for(int j=1;j<=m;j++) {
				map[i][j]=str.charAt(j-1)-'0';
			}
		}
		
		bfs();
		System.out.println(map[n][m]);
		
	}
}
