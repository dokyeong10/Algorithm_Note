import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Graph {
static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T =Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <=T ; test_case++) {
            StringTokenizer st =new StringTokenizer(br.readLine()," ");

            N=Integer.parseInt(st.nextToken()); //from, To 개수
            M=Integer.parseInt(st.nextToken()); //시작점

            Queue<Point> q =new LinkedList<>();
            boolean map[][]=new boolean[101][101];
            boolean visit[] =new boolean[101];
            st=new StringTokenizer(br.readLine()," ");

            for (int i = 0; i <N/2; i++) {
                int from =Integer.parseInt(st.nextToken());
                int to =Integer.parseInt(st.nextToken());
                map[from][to]=true;
            }
            int max=0;
            q.offer(new Point(M,0)); //시작점 넣기
            visit[M]=true;
            while(!q.isEmpty()){
                Point cur=q.poll();



            }



        }// end of tc
    }// end of main
static class Point {
        int x,y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
}

} // end of class
